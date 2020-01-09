package by.htp.wa.service;

import by.htp.wa.bean.User;

public interface ServiceUser {

	User authorization(String login, String password) throws ServiceException;

	Boolean registration(User user) throws ServiceException;

}
