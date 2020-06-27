package mainFolder.common;

import java.io.Serializable;

public class UserBasicInfoClass implements Serializable {
	private String userName;
	private int userGrade;
	private int userIsd;
	
	public UserBasicInfoClass(String userName, int userGrade, int userIsd) {
		this.userName = userName;
		this.userGrade = userGrade;
		this.userIsd  = userIsd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	public int getUserIsd() {
		return userIsd;
	}

	public void setUserIsd(int userIsd) {
		this.userIsd = userIsd;
	}

	
}
