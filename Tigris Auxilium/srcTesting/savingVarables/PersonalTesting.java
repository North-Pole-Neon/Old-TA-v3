package savingVarables;

import java.io.Serializable;

public class PersonalTesting implements Serializable {

	private String name;
	private int grade;
	private int isd;
	
	public PersonalTesting(String name, int grade, int isd) {
		this.name = name;
		this.grade = grade;
		this.isd = isd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getIsd() {
		return isd;
	}

	public void setIsd(int isd) {
		this.isd = isd;
	}
}
