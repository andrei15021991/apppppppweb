package by.htp.wa.command.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.bean.Question;
import by.htp.wa.command.Command;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceProvider;
import by.htp.wa.service.ServiceQuestion;

import static by.htp.wa.command.impl.CommandsParam.TEST1Q_PAGE_START;
import static by.htp.wa.command.impl.CommandsParam.TEST_NAME;

public class StartTest implements Command {
	private static final Logger LOGGER = Logger.getLogger(StartTest.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(true);

		String testName = request.getParameter(TEST_NAME);

		List<Question> questions = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ServiceQuestion serviceQuestion = serviceProvider.getServiceQuestion();

		try {
			questions = serviceQuestion.selTest(testName);

			httpSession.setAttribute("questions", questions);
		} catch (ServiceException e) {
			LOGGER.log(Level.WARNING, "database error");
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST1Q_PAGE_START);
		requestDispatcher.forward(request, response);

	}

}
