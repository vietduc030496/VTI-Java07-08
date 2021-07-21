package b3;

public class Truck extends Car{
	private int weight;
	 
	@Override
	public double getSalePrice() {
		if(this.weight>0) {
			if(this.weight>2000) {
				return this.getRegularPrice()*0.1;
			}else {
				return this.getRegularPrice()*0.2;
			}
		}else {
			return 0;
		}
		
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Truck(int weight) {
		super();
		this.weight = weight;
	}
	
}
