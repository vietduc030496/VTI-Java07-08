package Bai3;

public class Truck extends Car{
    private int weight;

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Truck() {
    }

    @Override
    public double getSalePrice() {
        double saleprice;
        if ( weight > 2000) saleprice = this.getRegularPrice()*0.9;
        else saleprice= this.getRegularPrice()*0.8;
        return saleprice;
    }

}
