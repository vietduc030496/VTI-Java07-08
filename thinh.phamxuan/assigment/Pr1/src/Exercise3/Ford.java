package Exercise3;

public class Ford extends Car {
	private int year; 
	private int manufacturerDiscount;
	
	public Ford() {
		super();
	}
	
	public Ford(int year, int manufacturerDiscount) {

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
		return this.getRegularPrice()*(100-this.manufacturerDiscount)/100;
	};
}
