package by.htp.wa.dao;

import java.util.List;

import by.htp.wa.bean.Question;

public interface DAOQuestion {
	
	List<Question> selectTest(String testName) throws DAOException;
	List<String> watchTest(String testname) throws DAOException;

}
