package by.htp.wa.service;

import by.htp.wa.service.impl.ServiceQuestionImpl;
import by.htp.wa.service.impl.ServiceResultImpl;
import by.htp.wa.service.impl.ServiceUserImpl;

public final class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private ServiceUser serviceUser = new ServiceUserImpl();
	private ServiceQuestion serviceQuestion = new ServiceQuestionImpl();
	private ServiceResult serviceResult = new ServiceResultImpl();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public ServiceUser getServiceUser() {
		return serviceUser;
	}

	public ServiceQuestion getServiceQuestion() {
		return serviceQuestion;
	}

	public ServiceResult getServiceResult() {
		return serviceResult;
	}

}
