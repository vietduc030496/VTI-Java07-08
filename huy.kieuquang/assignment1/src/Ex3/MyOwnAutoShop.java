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
public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.setLength(30);
        sedan.setColor("blue");
        sedan.setRegularPrice(10000);
        sedan.setSpeed(400);
        System.out.println(sedan.toString() + "  salePrice: "+ sedan.getSalePrice());
        
        Ford ford = new Ford();
        ford.setColor("red");
        ford.setRegularPrice(10000);
        ford.setSpeed(300);
        ford.setYear(1);
        ford.setManufacturerDiscount(20);
        System.out.println(ford.toString() + "  salePrice: "+ ford.getSalePrice());
        
        Ford ford2 = new Ford();
        ford2.setColor("white");
        ford2.setRegularPrice(15000);
        ford2.setSpeed(300);
        ford2.setYear(1);
        ford2.setManufacturerDiscount(20);
        System.out.println(ford2.toString() + "  salePrice: "+ ford2.getSalePrice());
        
        Car car = new Car();
        car.setColor("blue");
        car.setRegularPrice(10000);
        car.setSpeed(400);
        System.out.println(car.toString()+"  salePrice: "+car.getSalePrice());
    }
}
