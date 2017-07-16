package sqlcomp.base;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;


public class Util {
	
	private static final Logger logger = Logger.getLogger(Util.class);
	private static final String DEFAULT_PORT = "1433";
	private static final String DATA_BASE_USERNAME = "sa";
	private static final String URL_FROMAT = "jdbc:jtds:sqlserver://%s:%s;DatabaseName=%s";

	public static final String JDBCDriver = "net.sourceforge.jtds.jdbc.Driver";
	public static final String ODBCDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	
	
	public static Connection getConnection(String port, DBConfig config){
		String url = null;
		if(port == null || port.isEmpty())
			port = DEFAULT_PORT;
		try {
			url = String.format(URL_FROMAT, config.getDbIp(), port, config.getDbName());
			Class.forName(JDBCDriver);
			DriverManager.setLoginTimeout(10);
			return DriverManager.getConnection(url, DATA_BASE_USERNAME, config.getUserPwd());
		}catch(Exception e){
			logger.error("get connection fail url =" + url +
					", name=" + DATA_BASE_USERNAME + ", password=" + config.getUserPwd(), e);
		}
		return null ;
	}
}
