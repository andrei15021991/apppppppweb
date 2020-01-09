package by.htp.wa.dao;

import by.htp.wa.dao.impl.DAOQuestionImpl;
import by.htp.wa.dao.impl.DAOResultImpl;
import by.htp.wa.dao.impl.DAOUserImpl;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private DAOUser daoUser = new DAOUserImpl();
	private DAOQuestion daoQuestion = new DAOQuestionImpl();
	private DAOResult daoResult = new DAOResultImpl();

	private DAOProvider() {

	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public DAOUser getDaoUser() {
		return daoUser;
	}

	public DAOQuestion getDaoQuestion() {
		return daoQuestion;
	}

	public DAOResult getDaoResult() {
		return daoResult;
	}

}
