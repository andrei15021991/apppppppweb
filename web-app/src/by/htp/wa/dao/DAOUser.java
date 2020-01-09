package by.htp.wa.dao;

import by.htp.wa.bean.User;

public interface DAOUser {

	User authorization(String login, String password) throws DAOException;

	Boolean registration(User user) throws DAOException;

}
