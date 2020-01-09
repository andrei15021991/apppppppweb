package by.htp.wa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.wa.bean.User;
import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOUser;
import by.htp.wa.dao.connectionpool.ConnectionPool;

public class DAOUserImpl implements DAOUser {

	private final static String AUTSQL = "SELECT firstname,lastname,email FROM userdetail inner join user on user.iduser = userDetail.user_iduser WHERE user.login = ? AND user.password= ?";

	private final static String REGSQL1 = "INSERT INTO user(login, password) VALUES (?,?)";

	private final static String REGSQL2 = "INSERT INTO userDetail(firstname,lastname,email,user_iduser)"
			+ "VALUES(?,?,?,(select iduser from user where login=? and password=?))";

	@Override
	public User authorization(String login, String password) throws DAOException {
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionPool.getInstance().takeConnection();

			preparedStatement = connection.prepareStatement(AUTSQL);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String email = resultSet.getString("email");

				user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
			}

		} catch (SQLException | InterruptedException e) {
			throw new DAOException(e);
		} finally {
			ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
		}

		return user;
	}

	@Override
	public Boolean registration(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows;
		boolean isRegistrated = false;

		try {

			connection = ConnectionPool.getInstance().takeConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(REGSQL1);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());

			rows = preparedStatement.executeUpdate();
			preparedStatement.close();

			preparedStatement = connection.prepareStatement(REGSQL2);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getLogin());
			preparedStatement.setString(5, user.getPassword());

			rows = preparedStatement.executeUpdate();
			connection.commit();

			isRegistrated = true;

		} catch (SQLException | InterruptedException e) {
			throw new DAOException(e);
		} finally {
			ConnectionPool.getInstance().closeConnection(connection, preparedStatement);
		}
		return isRegistrated;
	}

}
