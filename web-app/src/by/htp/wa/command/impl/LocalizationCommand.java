package by.htp.wa.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.command.Command;

public class LocalizationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String local;
		HttpSession httpSession = request.getSession(true);

		local = request.getParameter("local");
		httpSession.setAttribute("local", local);

		String redirect = (String) httpSession.getAttribute("change_loc");

		if (redirect.endsWith(".jsp")) {
			request.getRequestDispatcher(redirect).forward(request, response);
		} else {
			response.sendRedirect(redirect);
		}

	}

}
