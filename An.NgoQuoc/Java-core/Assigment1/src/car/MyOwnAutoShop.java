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
public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan(300,150,200000.0, "red");
        Ford ford1 = new Ford(2020, 10, 160, 150000.0, "blue");
        Ford ford2 = new Ford(2021, 8, 160, 150000.0, "red");
        Car car = new Car(200,100000.0,"black");
        System.out.println("Sedan:" + sedan.getSalePrice(sedan.getRegulaPrice()) );
        System.out.println("Ford1:" + ford1.getSalePrice(ford1.getRegulaPrice()) );
        System.out.println("Ford2:" + ford2.getSalePrice(ford2.getRegulaPrice()));
        System.out.println("Car:" + car.getSalePrice(car.getRegulaPrice()));
    }
}
