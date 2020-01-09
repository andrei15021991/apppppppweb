package by.htp.wa.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.bean.User;
import by.htp.wa.command.Command;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceProvider;
import by.htp.wa.service.ServiceResult;

import static by.htp.wa.command.impl.CommandsParam.TEST_NAME;
import static by.htp.wa.command.impl.CommandsParam.CORRECT;
import static by.htp.wa.command.impl.CommandsParam.PASSED;
import static by.htp.wa.command.impl.CommandsParam.FAILED;
import static by.htp.wa.command.impl.CommandsParam.TEST_PASSED;
import static by.htp.wa.command.impl.CommandsParam.TEST_FAILED;

public class TestResult implements Command {
	private static final Logger LOGGER = Logger.getLogger(TestResult.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider serviceProvider = null;
		ServiceResult serviceResult = null;
		User user = null;

		HttpSession httpSession = request.getSession(true);

		String testName = request.getParameter(TEST_NAME);

		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");

		String res = null;

		int count = 0;

		List<String> result = new ArrayList<String>();
		result.add(a1);
		result.add(a2);
		result.add(a3);

		for (String r : result) {
			if (r.equals(CORRECT)) {
				count++;
			}
		}

		if (count == 3) {
			res = PASSED;
		} else {
			res = FAILED;
		}

		try {
			serviceProvider = ServiceProvider.getInstance();
			serviceResult = serviceProvider.getServiceResult();

			user = (User) httpSession.getAttribute("user");
			String firstName = user.getFirstName();
			String lastName = user.getLastName();

			serviceResult.result(firstName, lastName, testName, res);
		} catch (ServiceException e) {
			LOGGER.log(Level.WARNING, "database error");
		}

		if (res == PASSED) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST_PASSED);
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST_FAILED);
			requestDispatcher.forward(request, response);
		}

	}

}
