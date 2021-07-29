package com.vti.exercise3;

public class Truck extends Car {

	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		}
		throw new IllegalArgumentException("Trong luong phai lon hon 0");
	}

	@Override
	public double getSalePrice() {
		if (weight > 2000) {
			return getRegularPrice() * 0.95;
		}
		return getRegularPrice() * 0.9;
	}

}
