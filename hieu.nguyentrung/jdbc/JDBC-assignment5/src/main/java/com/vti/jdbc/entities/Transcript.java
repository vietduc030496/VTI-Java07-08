package com.vti.jdbc.entities;

public class Transcript {
	private int studentID;
	private int subjectID;
	private float score;
	public Transcript() {
		// TODO Auto-generated constructor stub
	}
	public Transcript(int studentID, int subjectID, float score) {
		super();
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.score = score;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
	
}
