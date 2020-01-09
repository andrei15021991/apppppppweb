package by.htp.wa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.wa.bean.Question;
import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOQuestion;
import by.htp.wa.dao.connectionpool.ConnectionPool;

public class DAOQuestionImpl implements DAOQuestion {
	private final static String SQL_LIST = "SELECT question, answer FROM testquestions INNER JOIN test ON test.idtest = testquestions.test_idtest WHERE test.testname = ?";
	private final static String SQL_LIST_WATCH = "SELECT question FROM testquestions INNER JOIN test ON test.idtest = testquestions.test_idtest WHERE test.testname = ?";

	@Override
	public List<Question> selectTest(String testName) throws DAOException {
		List<Question> questions = new ArrayList<Question>();
		Question testquestion = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = ConnectionPool.getInstance().takeConnection();

			preparedStatement = connection.prepareStatement(SQL_LIST);
			preparedStatement.setString(1, testName);

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				testquestion = new Question();

				testquestion.setQuestion(resultset.getString("question"));
				testquestion.setAnswer(resultset.getString("answer"));

				questions.add(testquestion);

			}

		} catch (InterruptedException | SQLException e) {
			throw new DAOException();
		} finally {
			ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultset);
		}

		return questions;
	}

	@Override
	public List<String> watchTest(String testname) throws DAOException {
		List<String> watchQuestions = new ArrayList<String>();
		String testQuestion = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = ConnectionPool.getInstance().takeConnection();

			preparedStatement = connection.prepareStatement(SQL_LIST_WATCH);
			preparedStatement.setString(1, testname);

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {

				testQuestion = resultset.getString("question");

				watchQuestions.add(testQuestion);

			}

		} catch (InterruptedException | SQLException e) {
			throw new DAOException();
		} finally {
			ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultset);
		}
		return watchQuestions;
	}

}
