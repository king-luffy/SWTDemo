package sqlcomp.base;

public class DBConfig {
	private String dbIp = "";
	private String dbName = "";
	private String userName = "";
	private String userPwd = "";

	public String getDbIp() {
		return dbIp;
	}

	public void setDbIp(String dbIp) {
		this.dbIp = dbIp;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DBConfig{");
		sb.append("dbIp='").append(dbIp).append('\'');
		sb.append(", dbName='").append(dbName).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", userPwd='").append(userPwd).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
