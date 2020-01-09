package by.htp.wa.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.wa.command.impl.CommandsParam.LOGIN;
import static by.htp.wa.command.impl.CommandsParam.PASSWORD;
import static by.htp.wa.command.impl.CommandsParam.FIRSTNAME;
import static by.htp.wa.command.impl.CommandsParam.LASTNAME;
import static by.htp.wa.command.impl.CommandsParam.EMAIL;
import static by.htp.wa.command.impl.CommandsParam.E_REG;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.htp.wa.bean.User;
import by.htp.wa.command.Command;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceProvider;
import by.htp.wa.service.ServiceUser;

public class RegistrationCommand implements Command {
	private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		String firstName;
		String lastName;
		String email;

		login = request.getParameter(LOGIN);
		password = request.getParameter(PASSWORD);
		firstName = request.getParameter(FIRSTNAME);
		lastName = request.getParameter(LASTNAME);
		email = request.getParameter(EMAIL);

		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);

		ServiceProvider serviceProvider = null;
		ServiceUser serviceUser = null;
		HttpSession httpSession = null;

		boolean registrated = false;

		try {
			serviceProvider = ServiceProvider.getInstance();
			serviceUser = serviceProvider.getServiceUser();

			registrated = serviceUser.registration(user);

		} catch (ServiceException e) {
			LOGGER.log(Level.WARNING, E_REG);
		}

		if (registrated == false) {
			httpSession = request.getSession(false);
			response.sendRedirect("Controller?command=go_to_registration&errorMessage=user already exist");
			return;
		} else {

			httpSession = request.getSession(true);
			httpSession.setAttribute("user", user);

			response.sendRedirect("Controller?command=go_to_main");
		}

	}

}
