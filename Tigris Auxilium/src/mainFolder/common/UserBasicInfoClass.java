package mainFolder.common;

import java.io.Serializable;

public class UserBasicInfoClass implements Serializable { //TODO Combine UBIC with this class
	private String userName;
	private int userGrade;
	private int userIsd;
	private boolean setupCompleted;
	
	public UserBasicInfoClass(String userName, int userGrade, int userIsd, boolean setupCompleted) {
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

	public boolean isSetupCompleted() {
		return setupCompleted;
	}

	public void setSetupCompleted(boolean setupCompleted) {
		this.setupCompleted = setupCompleted;
	}
	

	
}
