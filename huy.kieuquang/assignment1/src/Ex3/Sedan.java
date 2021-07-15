/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author kieuq
 */
public class Sedan extends Car{
    private int length;

    public Sedan() {
    }
   
    public Sedan(int length) {
        this.length = length;
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

    
    
    @Override
    public double getSalePrice(){
        if(length>20){
            this.setRegularPrice(this.getRegularPrice()*(1-0.05));            
            return this.getRegularPrice();
        }
        
        this.setRegularPrice(this.getRegularPrice()*(1-0.1));            
        return this.getRegularPrice();
    }

    @Override
    public String toString() {
        return "Sedan{" + "length=" + length + '}' +" "+ super.toString();
    }
    
    
}
