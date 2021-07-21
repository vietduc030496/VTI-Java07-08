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
public class Car {
    private int speed;
    private double regulaPrice;
    private String color;

    public Car() {
    }

    public Car(int speed, double regulaPrice, String color) {
        this.speed = speed;
        this.regulaPrice = regulaPrice;
        this.color = color;
    }
    public double getSalePrice(double regulaPrice){
        return regulaPrice;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRegulaPrice() {
        return regulaPrice;
    }

    public void setRegulaPrice(double regulaPrice) {
        this.regulaPrice = regulaPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
