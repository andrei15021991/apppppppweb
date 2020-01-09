package by.htp.wa.command.go.to.impl;

import java.io.IOException; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.command.Command;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceProvider;
import by.htp.wa.service.ServiceQuestion;

import static by.htp.wa.command.impl.CommandsParam.TEST_NAME;
import static by.htp.wa.command.impl.CommandsParam.TEST1Q_PAGE;

public class GoToTest implements Command {
	private static final Logger LOGGER = Logger.getLogger(GoToTest.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(true);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ServiceQuestion serviceQuestion = serviceProvider.getServiceQuestion();

		List<String> watchQuestions = null;
		String testName;

		testName = request.getParameter(TEST_NAME);

		try {
			watchQuestions = serviceQuestion.watchQ(testName);

			httpSession.setAttribute("watch", watchQuestions);
		} catch (ServiceException e) {
			LOGGER.log(Level.WARNING, "database error");
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST1Q_PAGE);
		requestDispatcher.forward(request, response);

	}

}
