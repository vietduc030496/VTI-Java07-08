package exercise3;

public class Truck extends Car {
	private int weight;

	public Truck() {
		super();
	}

	public Truck(int weight) {
		super();
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight>0) {
			this.weight = weight;
		}
		else {
			System.out.println("lương phải lớn hơn 0");
		}
	}
	@Override
	public double getSalePrice() {
		if (weight > 2000) {
			return getRegularPrice() * 0.9;
		}
		return getRegularPrice() * 0.8;
	}
}