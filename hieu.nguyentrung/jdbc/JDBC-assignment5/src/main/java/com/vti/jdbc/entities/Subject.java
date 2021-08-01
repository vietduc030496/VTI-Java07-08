package com.vti.jdbc.entities;

public class Subject {
	private int subjectID;
	private String subjectName;
	private int credits;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String subjectName, int credits) {
		super();
		this.subjectName = subjectName;
		this.credits = credits;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
	
	
}
