package by.htp.wa.service;

import java.util.List;

import by.htp.wa.bean.Question;

public interface ServiceQuestion {

	List<Question> selTest(String testName) throws ServiceException;
	List<String> watchQ(String testName) throws ServiceException;

}
