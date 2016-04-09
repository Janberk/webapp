package de.canberk.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.canberk.webapp.core.service.AccountService;

@Controller
public class MainController {

	protected static final Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected AccountService accountService;

	public static Logger getLog() {
		return log;
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

}
