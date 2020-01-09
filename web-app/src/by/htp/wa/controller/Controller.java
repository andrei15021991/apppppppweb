package by.htp.wa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.wa.dao.connectionpool.ConnectionPool;
import by.htp.wa.command.Command;
import by.htp.wa.command.CommandProvider;
import by.htp.wa.command.impl.AuthorizationCommand;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

	public static final String COMMAND = "command";
	private final CommandProvider commandProvider = new CommandProvider();
	private ConnectionPool cPool;

	public Controller() {
		super();

	}

	@Override
	public void init() throws ServletException {

		cPool = ConnectionPool.getInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command;

		String commandName = request.getParameter(COMMAND);

		command = commandProvider.getCommand(commandName);
		command.execute(request, response);

	}

	@Override
	public void destroy() {
		try {
			cPool.dispose();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "error closing the connection");
		}
	}

}
