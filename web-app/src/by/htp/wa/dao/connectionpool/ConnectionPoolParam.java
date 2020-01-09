package by.htp.wa.dao.connectionpool;

public final class ConnectionPoolParam {

	public static final String URL = "jdbc:mysql://127.0.0.1/test_system?serverTimezone=Europe/Moscow&useSSL=false";
	public static final String NAME = "root";
	public static final String PASS = "123456";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final int POOLSIZE = 5;

	private ConnectionPoolParam() {

	}

}
