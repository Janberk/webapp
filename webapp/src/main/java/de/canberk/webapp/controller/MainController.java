package de.canberk.webapp.controller;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import de.canberk.webapp.core.service.AccountService;
import de.canberk.webapp.model.Account;

@Controller
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);

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

	@RequestMapping(value = "/change-language", method = RequestMethod.GET)
	@ResponseBody
	public String changeLanguage(ModelAndView modelView, @RequestParam(value = "language") String language) {
		LocaleContextHolder.setLocale(new Locale(language));
		return language;
	}

}
