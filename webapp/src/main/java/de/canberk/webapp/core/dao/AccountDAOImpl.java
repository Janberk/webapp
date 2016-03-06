package de.canberk.webapp.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import de.canberk.webapp.configuration.ApplicationGrantedAuthority;
import de.canberk.webapp.model.Account;

@Primary
@Repository
public class AccountDAOImpl implements AccountDAO {

	private static final Logger log = LogManager.getLogger(AccountDAOImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void createAccount(Account account) {

		log.info("createAccount");

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(account);
		log.debug("Account saved successfully, Account details: " + account.getUserName());
	}

	@Override
	public void deleteAccountById(int id) {

		log.info("deleteAccountById");

		Session session = this.sessionFactory.getCurrentSession();
		Account account = (Account) session.load(Account.class, new Integer(id));
		if (account != null) {
			session.delete(account);
			log.debug("Account deleted successfully, Account details: " + account.getUserName());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listAllAccounts() {

		log.info("listAllAccounts");

		Session session = this.sessionFactory.getCurrentSession();
		List<Account> accounts = session.createQuery("from Account").list();

		return accounts;
	}

	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("loadUserByUsername");

		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Account a WHERE a.userName = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<Account> results = query.list();

		int id = results.get(0).getId();
		Account account = (Account) session.load(Account.class, new Integer(id));

		String password = account.getPassword();

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(ApplicationGrantedAuthority.ROLE_USER.name()));

		UserDetails user = new User(username, password, authorities);

		return user;
	}

	@Override
	public Account readAccountById(int id) {

		log.info("readAccountById");

		Session session = this.sessionFactory.getCurrentSession();
		Account account = (Account) session.load(Account.class, new Integer(id));
		log.debug("Account loaded successfully, Account details: " + account.getUserName());

		return account;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void updateAccount(Account account) {

		log.info("updateAccount");

		Session session = this.sessionFactory.getCurrentSession();
		session.update(account);
		log.debug("Account updated successfully, Account details: " + account.getUserName());
	}

}
