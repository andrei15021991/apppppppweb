package by.htp.wa.command.go.to.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.wa.command.Command;

public class GoToSignIn implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("change_loc", "/WEB-INF/jsp/signIn.jsp");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
