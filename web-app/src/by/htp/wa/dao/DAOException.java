package by.htp.wa.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 346976266245077011L;

	public DAOException(String message, Exception e) {
		super(message, e);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException() {
		super();
	}

}
