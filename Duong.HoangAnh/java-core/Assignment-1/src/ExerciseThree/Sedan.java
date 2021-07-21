package ExerciseThree;

public class Sedan extends Car {
	private int length;
	public Sedan(int s, double r, String c, int l) {
		super(s, r, c);
		this.setLength(l);
	}
	public int getLength() {
		return length;
	}
	public void setLength(int l) {
		length = l;
	}
	@Override
	public double getSalePrice() {
		double result = this.getRegularPrice();
		if(this.getLength() > 20) {
			result = 0.95*result;
		}
		else {
			result = 0.85*result;
		}
		return result;
	}
}
