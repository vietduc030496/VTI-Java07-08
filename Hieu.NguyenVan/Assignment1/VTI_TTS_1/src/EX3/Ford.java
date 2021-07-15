/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX3;

/**
 *
 * @author hieu.nguyenvan1
 */
public class Ford extends Car{
    private int year;
    private int manufactureDiscount;

    public Ford() {
        super();
    }

    public Ford(int year, int manufactureDiscount) {
        super();
        this.year = year;
        this.manufactureDiscount = manufactureDiscount;
    }

    public Ford(int year, int manufactureDiscount, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufactureDiscount = manufactureDiscount;
    }
    
    
    public double getSalePrice(){
        return this.getRegularPrice()-manufactureDiscount;
    }
    
}
