package de.canberk.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import de.canberk.webapp.core.service.AccountService;
import de.canberk.webapp.model.Account;

@Controller
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private AccountService service;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView modelView) {

		log.info("welcome");

		modelView.setViewName("welcome");
		return modelView;
	}

	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public ModelAndView myaccount(ModelAndView modelView) {

		log.info("myaccount");

		modelView.setViewName("myaccount");
		return modelView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelAndView modelView) {

		log.info("registration");

		modelView.setViewName("registration");
		Account account = new Account();
		modelView.getModelMap().put("account", account);
		return modelView;
	}

	@RequestMapping(value = "/submit-registration", method = RequestMethod.POST)
	public ModelAndView submitRegistration(@ModelAttribute("account") Account account, BindingResult result) {

		log.info("submitRegistration");

		service.createAccount(account);
		return new ModelAndView("redirect:/welcome");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelView) {

		log.info("login");

		modelView.setViewName("login");
		return modelView;
	}

	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView modelView) {

		log.info("logout");

		modelView.setViewName("logout-success");
		return modelView;
	}

	@RequestMapping(value = "/change-language/{language}", method = RequestMethod.GET)
	public String changeLanguage(@PathVariable(value = "language") String language) {
		LocaleContextHolder.setLocale(new Locale(language));
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(language));
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}
