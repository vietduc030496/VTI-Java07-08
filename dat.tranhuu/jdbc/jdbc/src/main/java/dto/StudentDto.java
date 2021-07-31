package dto;

import java.util.Date;

public class StudentDto {
	private Long id;
	private String name;
	private String firstName;
	private String gender;
	private Date dob;
	private String address;
	private String phone;
	private String email;
	private Long lopId;
	private String nameLop;
	private String year;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getLopId() {
		return lopId;
	}
	public void setLopId(Long lopId) {
		this.lopId = lopId;
	}
	public String getNameLop() {
		return nameLop;
	}
	public void setNameLop(String name_lop) {
		this.nameLop = name_lop;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
