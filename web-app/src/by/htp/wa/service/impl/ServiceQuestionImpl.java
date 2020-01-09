package by.htp.wa.service.impl;

import java.util.List;

import by.htp.wa.bean.Question;
import by.htp.wa.dao.DAOException;
import by.htp.wa.dao.DAOProvider;
import by.htp.wa.dao.DAOQuestion;
import by.htp.wa.service.ServiceException;
import by.htp.wa.service.ServiceQuestion;

public class ServiceQuestionImpl implements ServiceQuestion {

	@Override
	public List<Question> selTest(String testName) throws ServiceException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		DAOQuestion daoQuestion = daoProvider.getDaoQuestion();

		List<Question> questions = null;
		try {
			questions = daoQuestion.selectTest(testName);

			for (Question q : questions) {
				if (q.getQuestion() == null || q.getAnswer() == null) {
					throw new ServiceException();
				}
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return questions;
	}

	@Override
	public List<String> watchQ(String testName) throws ServiceException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		DAOQuestion daoQuestion = daoProvider.getDaoQuestion();

		List<String> questions = null;
		try {
			questions = daoQuestion.watchTest(testName);

			for (String q : questions) {
				if (q == null) {
					throw new ServiceException();
				}
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return questions;
	}

}
