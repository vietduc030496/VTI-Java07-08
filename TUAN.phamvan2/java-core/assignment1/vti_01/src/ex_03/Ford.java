package ex_03;

public class Ford extends Car {
	private int year;
	private int manufacturerDiscount;

	public Ford() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ford(int speed, double regularPrice, String color) {
		super(speed, regularPrice, color);
		// TODO Auto-generated constructor stub
	}

	public Ford(int year, int manufacturerDiscount) {
		super();
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}

	public void setManufacturerDiscount(int manufacturerDiscount) {
		this.manufacturerDiscount = manufacturerDiscount;
	}

	public double getSalePrice() {
		if (this.manufacturerDiscount > 0) {
			return this.getRegularPrice() * this.manufacturerDiscount / 100;
		} else return this.getRegularPrice();
	}
}
