package de.canberk.webapp.core.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import de.canberk.webapp.model.Account;

public interface AccountService {

	void createAccount(Account account);

	void deleteAccountById(int id);

	List<Account> listAllAccounts();

	UserDetails loadUserByUsername(String username);

	Account readAccountById(int id);

	void updateAccount(Account account);

}
