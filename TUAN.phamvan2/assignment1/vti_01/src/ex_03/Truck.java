package ex_03;

public class Truck extends Car {
	private int weight;

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(int speed, double regularPrice, String color) {
		super(speed, regularPrice, color);
		// TODO Auto-generated constructor stub
	}

	public Truck(int weight) {
		super();
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getSalePrice() {
		if (this.weight > 2000) {
			return this.getRegularPrice() * 0.9;
		} else {
			return this.getRegularPrice() * 0.8;
		}

	}
}
