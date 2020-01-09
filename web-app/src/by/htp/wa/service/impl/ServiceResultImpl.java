package by.htp.wa.service.impl;

import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOProvider;
import by.htp.wa.dao.DAOResult;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceResult;

import static by.htp.wa.command.impl.CommandsParam.PASSED;
import static by.htp.wa.command.impl.CommandsParam.FAILED;

public class ServiceResultImpl implements ServiceResult {

	@Override
	public void result(String firstName, String lastName, String testName, String result) throws ServiceException {
		DAOProvider daoProvider = null;
		DAOResult daoResult = null;

		try {
			daoProvider = DAOProvider.getInstance();
			daoResult = daoProvider.getDaoResult();

			if (result.equals(PASSED) || result.equals(FAILED)) {

				daoResult.result(firstName, lastName, testName, result);
			} else
				throw new ServiceException();

		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

}
