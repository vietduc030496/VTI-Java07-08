package Bai3;

public class Ford extends Car{
    private int year;
    private int manufacturerDiscount;

    public Ford(int year, int manufacturerDiscount) {
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public Ford() {

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

    @Override
    public double getSalePrice() {
        return (this.getRegularPrice()- (double)manufacturerDiscount);
    }
}
