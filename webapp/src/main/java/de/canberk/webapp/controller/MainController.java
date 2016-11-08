package de.canberk.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import de.canberk.webapp.core.service.AccountService;
import de.canberk.webapp.core.service.AddressService;
import de.canberk.webapp.model.Profile;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MainController {

	protected static final Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	protected Profile profile;

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected AccountService accountService;

	@Autowired
	protected AddressService addressService;

	public static Logger getLog() {
		return log;
	}

	public Profile getProfile() {
		return profile;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

}
