package ExerciseThree;

abstract class Car {
	private int speed;
	private double regularPrice;
	private String color;
	public Car(int s, double r, String c) {
		this.setSpeed(s);
		this.setRegularPrice(r);
		this.setColor(c);
	}
	public void setSpeed(int s) {
		speed = s;
	}
	public int getSpeed() {
		return speed;
	}
	public void setRegularPrice(double rP) {
		regularPrice = rP;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setColor(String c) {
		color = c;
	}
	public String getColor() {
		return color;
	}
	abstract public double getSalePrice();
}
