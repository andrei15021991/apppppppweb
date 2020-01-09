package by.htp.wa.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -402935987634641067L;

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
		super();
	}
}
