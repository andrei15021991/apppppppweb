package by.htp.wa.command.impl;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.bean.User;
import by.htp.wa.command.Command;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceProvider;
import by.htp.wa.service.ServiceUser;

import static by.htp.wa.command.impl.CommandsParam.LOGIN;
import static by.htp.wa.command.impl.CommandsParam.PASSWORD;
import static by.htp.wa.command.impl.CommandsParam.E_AUT;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorizationCommand implements Command {
	private static final Logger LOGGER = Logger.getLogger(AuthorizationCommand.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter(LOGIN);
		password = request.getParameter(PASSWORD);

		ServiceProvider serviceProvider = null;
		ServiceUser serviceUser = null;

		User user = null;
		HttpSession httpSession = null;

		try {
			serviceProvider = ServiceProvider.getInstance();
			serviceUser = serviceProvider.getServiceUser();

			user = serviceUser.authorization(login, password);
			if (user == null) {
				httpSession = request.getSession(false);
				response.sendRedirect("Controller?command=go_to_sign_in&errorMessage=wrong login or password");
				return;
			}
			httpSession = request.getSession(true);

		} catch (ServiceException e) {
			LOGGER.log(Level.WARNING, E_AUT);

		}
		httpSession.setAttribute("change_loc", "Controller?command=go_to_main");
		httpSession.setAttribute("user", user);
		response.sendRedirect("Controller?command=go_to_main");

	}

}
