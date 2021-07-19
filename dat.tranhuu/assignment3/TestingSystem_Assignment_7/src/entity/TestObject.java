package entity;

import java.io.Serializable;

public class TestObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2172513099898000816L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestObject(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
