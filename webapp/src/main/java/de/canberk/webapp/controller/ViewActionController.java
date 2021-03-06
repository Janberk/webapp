package de.canberk.webapp.controller;

import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import de.canberk.webapp.model.Account;
import de.canberk.webapp.model.Address;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ViewActionController extends MainController {

	@RequestMapping(value = "/submit-registration", method = RequestMethod.POST)
	public ModelAndView submitRegistration(@ModelAttribute("account") Account account, BindingResult result) {

		getLog().info("submitRegistration");
		getAccountService().createAccount(account);
		return new ModelAndView("redirect:/welcome");
	}

	@RequestMapping(value = "/save-address", method = RequestMethod.POST)
	public ModelAndView saveAddress(@ModelAttribute("address") Address address, BindingResult result) {

		getLog().info("saveAddress");

		if (result.hasErrors()) {
			getLog().info("Address form has errors!");
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();

		getAddressService().createAddress(address, userName);
		return new ModelAndView("redirect:/welcome");
	}

	@RequestMapping(value = "/change-language/{language}", method = RequestMethod.GET)
	public String changeLanguage(@PathVariable(value = "language") String language) {

		getLog().info("changeLanguage");

		LocaleContextHolder.setLocale(new Locale(language));
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(language));
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}
