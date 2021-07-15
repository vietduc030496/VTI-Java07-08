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
public class Truck extends Car{
    private int weight;

    public Truck(int weight, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getSalePrice(){
        if (weight>2000){
            double sale_price = super.getRegularPrice() - super.getRegularPrice()*0.1;
            return sale_price;
        }
        else{
            double sale_price = super.getRegularPrice() - super.getRegularPrice()*0.2;
            return sale_price;
        }
    }
    
}
