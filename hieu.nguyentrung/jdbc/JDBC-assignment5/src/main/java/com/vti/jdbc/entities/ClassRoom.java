package com.vti.jdbc.entities;

public class ClassRoom {
	private int classID;
	private String nameClass;
	private String schoolYear;

	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(int classID, String nameClass, String schoolYear) {
		super();
		this.classID = classID;
		this.nameClass = nameClass;
		this.schoolYear = schoolYear;
	}

	public ClassRoom(String nameClass, String schoolYear) {
		super();
		this.nameClass = nameClass;
		this.schoolYear = schoolYear;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

}
