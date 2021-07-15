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
public class Truck extends Car{
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, int speed, double regulaPrice, String color) {
        super(speed, regulaPrice, color);
        this.weight = weight;
    }
    @Override
    public double getSalePrice(double regulaPrice){
        double saleprice = regulaPrice;
        if(weight>2000){
            saleprice -= regulaPrice*0.1;
        }
        else{
            saleprice -= regulaPrice*0.2;
        }
        return saleprice;
    }
}
