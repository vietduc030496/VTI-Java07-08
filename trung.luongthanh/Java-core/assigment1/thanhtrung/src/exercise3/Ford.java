package exercise3;

public class Ford extends Car{
	private int year;
 	private int manufacturerDiscount;
	public Ford() {
		super();
	}
	
	public int getYear() {
		return year;
	}
	
	public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}
	public void setManufacturerDiscount(int manufacturerDiscount) {
		if(manufacturerDiscount>=0)this.manufacturerDiscount = manufacturerDiscount;
		else System.out.println("giá ưu đãi phải lớn hơn hoặc bằng 0");
	}
	@Override
	public double getSalePrice() {
		return getRegularPrice()-getManufacturerDiscount();
	}
}
