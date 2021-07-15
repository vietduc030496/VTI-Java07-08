package ExerciseThree;

public class Truck extends Car {
	private int weight;
	public Truck(int s, double r, String c, int w) {
		super(s, r, c);
		this.setWeight(w);
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int w) {
		weight = w;
	}
	public double getSalePrice() {
		double result = this.getRegularPrice();
		if(this.getWeight() > 2000) {
			result = 0.9*result;
		}else {
			result = 0.8*result;
		}
		return result;
	}
}
