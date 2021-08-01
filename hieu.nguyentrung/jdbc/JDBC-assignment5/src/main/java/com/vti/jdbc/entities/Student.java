package com.vti.jdbc.entities;


public class Student {
	private int studentID;
	private int classID;
	private String firstName;
	private String name;
	private String gender;
	private String birthDate;
	private String address;
	private String phoneNumber;
	private String email;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int classID, String firstName, String name, String gender, String birthDate, String address,
			String phoneNumber, String email) {
		super();
		this.classID = classID;
		this.firstName = firstName;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
