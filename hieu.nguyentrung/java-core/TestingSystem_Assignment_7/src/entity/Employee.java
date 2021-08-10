package entity;

import java.io.Serializable;

public class Employee implements Serializable {
	public static final long serialVersionUID =1L;
	private String name ;
	private int age;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
