package ExerciseThree;

public class Ford extends Car{
	private int year;
	private int manufacturerDiscount;
	public Ford(int s, double r, String c, int y, int manu) {
		super(s, r, c);
		this.setYear(y);
		this.setManufacturerDiscount(manu);
	}
	public void setYear(int y) {
		year = y;
	}
	public int getYear() {
		return year;
	}
	public void setManufacturerDiscount(int manu) {
		manufacturerDiscount = manu;
	}
	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}
	public double getSalePrice() {
		double result = this.getRegularPrice() - this.getManufacturerDiscount();
		return result;
	}
}
