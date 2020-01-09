package by.htp.wa.service.impl;

import by.htp.wa.bean.User;
import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOProvider;
import by.htp.wa.dao.DAOUser;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceUser;

public class ServiceUserImpl implements ServiceUser {

	@Override
	public User authorization(String login, String password) throws ServiceException {
		DAOProvider daoProvider = null;
		DAOUser daoUser = null;
		User user = null;

		if (login == null) {
			throw new ServiceException();
		}

		if (password == null) {
			throw new ServiceException();
		}

		try {
			daoProvider = DAOProvider.getInstance();
			daoUser = daoProvider.getDaoUser();
			user = daoUser.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException();
		}

		return user;
	}

	@Override
	public Boolean registration(User user) throws ServiceException {
		boolean registrated = false;

		DAOProvider daoProvider = null;
		DAOUser daoUser = null;

		try {
			daoProvider = DAOProvider.getInstance();
			daoUser = daoProvider.getDaoUser();

			registrated = daoUser.registration(user);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return registrated;
	}

}
