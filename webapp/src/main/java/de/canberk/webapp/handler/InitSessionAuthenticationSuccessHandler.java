package de.canberk.webapp.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.canberk.webapp.model.Profile;

public class InitSessionAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		User user = (User) authentication.getPrincipal();
		String username = user.getUsername();
		Profile profile = (Profile) request.getSession(false).getAttribute("scopedTarget.profile");
		if (profile != null) {
			profile.setName(username);
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
