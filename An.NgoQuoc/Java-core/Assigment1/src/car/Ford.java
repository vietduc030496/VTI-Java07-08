/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

/**
 *
 * @author LENOVO
 */
public class Ford extends Car{
    private int year;
    private int manufacturerDiscount;

    public Ford(int year, int manufacturerDiscount, int speed, double regulaPrice, String color) {
        super(speed, regulaPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }
    @Override
    public double getSalePrice(double regulaPrice){
        return regulaPrice-regulaPrice*manufacturerDiscount*0.01;
    }
    
}
