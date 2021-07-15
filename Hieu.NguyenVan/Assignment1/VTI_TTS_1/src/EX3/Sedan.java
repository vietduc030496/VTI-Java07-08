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
public class Sedan extends Car {
    private int length;

    public Sedan(int length) {
       super();
        this.length = length;
    }

    public Sedan(int length, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public Sedan() {
        super();
    }

    public Sedan(int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
    }
    public double getSalePrice(){
         int discount=10;
         if(this.length>20) discount=25;
         return  this.getRegularPrice() +this.getRegularPrice()/discount;
    }
    
    
}
