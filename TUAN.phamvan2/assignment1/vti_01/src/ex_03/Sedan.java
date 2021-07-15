package ex_03;

public class Sedan extends Car	{
	private int length;

	public Sedan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sedan(int speed, double regularPrice, String color) {
		super(speed, regularPrice, color);
		// TODO Auto-generated constructor stub
	}

	public Sedan(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public double getSalePrice() {
		if(this.length > 20) {
			return this.getRegularPrice() * 0.95;
		} else return this.getRegularPrice() * 0.9;
	}
}
