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
public class Sedan extends Car{
    private int lenght;

    public Sedan(int lenght, int speed, double regulaPrice, String color) {
        super(speed, regulaPrice, color);
        this.lenght = lenght;
    }
    @Override
    public double getSalePrice(double regulaPrice){
        double saleprice = regulaPrice;
        if(lenght>200){
            saleprice -= regulaPrice*0.05;
        }
        else{
            saleprice -= regulaPrice*0.01;
        }
        return saleprice;
    }
}
