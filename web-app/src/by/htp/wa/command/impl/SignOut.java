package by.htp.wa.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.command.Command;

public class SignOut implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		if (httpSession != null) {
			httpSession.removeAttribute("user");
			httpSession.setAttribute("change_loc", "/WEB-INF/jsp/signIn.jsp");
		}

		response.sendRedirect("Controller?command=go_to_sign_in");

	}

}
