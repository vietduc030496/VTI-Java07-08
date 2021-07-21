package Exercise3;

public class Truck extends Car {
	private int weight;
	
	public Truck() {
		super();
	}
	
	public Truck(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getSalePrice() {
		if(this.weight>2000) {
			return this.getRegularPrice()*0.9;
		}
		else {
			return this.getRegularPrice()*0.8;
		}
	};
 
}
