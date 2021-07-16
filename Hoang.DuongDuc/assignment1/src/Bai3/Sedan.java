package Bai3;

public class Sedan extends Car{
    private int length;

    public Sedan(int length) {
        this.length = length;
    }

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public Sedan() {

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        double saleprice;
        if ( length > 20) saleprice = this.getRegularPrice()*0.95;
        else saleprice= this.getRegularPrice()*0.9;
        return saleprice;
    }
}
