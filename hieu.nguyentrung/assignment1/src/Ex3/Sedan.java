/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author ADMIN
 */
public class Sedan extends Car {

    private int length;

    public Sedan() {
    }

    public Sedan(int length, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getSalePrice() {
        if (length > 20) {
            double sale_price = super.getRegularPrice() - super.getRegularPrice() * 0.05;
            return sale_price;
        } else {
            double sale_price = super.getRegularPrice() - super.getRegularPrice() * 0.1;
            return sale_price;
        }
    }

}
