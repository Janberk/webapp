package de.canberk.webapp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import de.canberk.webapp.model.Account;
import de.canberk.webapp.model.Address;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ViewController extends MainController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView modelView) {

		getLog().info("welcome");

		modelView.setViewName("welcome");
		return modelView;
	}

	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public ModelAndView myaccount(ModelAndView modelView) {

		getLog().info("myaccount");

		modelView.setViewName("myaccount");
		modelView.addObject("address", new Address());
		return modelView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelAndView modelView) {

		getLog().info("registration");

		modelView.setViewName("registration");
		Account account = new Account();
		modelView.getModelMap().put("account", account);
		return modelView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelView) {

		getLog().info("login");

		modelView.setViewName("login");
		return modelView;
	}

	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView modelView) {

		getLog().info("logout");

		modelView.setViewName("logout-success");
		return modelView;
	}

}
