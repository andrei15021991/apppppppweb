package by.htp.wa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOResult;
import by.htp.wa.dao.connectionpool.ConnectionPool;

public class DAOResultImpl implements DAOResult {

	private final static String RES_SQL = "INSERT INTO user_has_test(user_iduser,test_idtest,result) VALUES((select user_iduser from userdetail where firstname=? and lastname=?),(select idtest from test where testname=?),?)";

	@Override
	public void result(String firstName, String lastName, String testName, String result) throws DAOException {
		Connection connection = null;
		PreparedStatement praPreparedStatement = null;
		int rows;

		try {

			connection = ConnectionPool.getInstance().takeConnection();
			connection.setAutoCommit(false);

			praPreparedStatement = connection.prepareStatement(RES_SQL);
			praPreparedStatement.setString(1, firstName);
			praPreparedStatement.setString(2, lastName);
			praPreparedStatement.setString(3, testName);
			praPreparedStatement.setString(4, result);

			rows = praPreparedStatement.executeUpdate();
			connection.commit();

		} catch (SQLException | InterruptedException e) {
			throw new DAOException(e);
		} finally {
			ConnectionPool.getInstance().closeConnection(connection, praPreparedStatement);
		}

	}

}
