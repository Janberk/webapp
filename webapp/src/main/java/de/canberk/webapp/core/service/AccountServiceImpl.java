package de.canberk.webapp.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.canberk.webapp.core.dao.AccountDAO;
import de.canberk.webapp.model.Account;

@Service
@Primary
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {

	@Autowired
	private AccountDAO dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createAccount(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		this.dao.createAccount(account);
	}

	@Override
	public void deleteAccountById(int id) {
		this.dao.deleteAccountById(id);
	}

	@Override
	public List<Account> listAllAccounts() {
		return this.dao.listAllAccounts();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.dao.loadUserByUsername(username);
	}

	@Override
	public Account readAccountById(int id) {
		return this.dao.readAccountById(id);
	}

	@Override
	public void updateAccount(Account account) {
		this.dao.updateAccount(account);
	}

}
