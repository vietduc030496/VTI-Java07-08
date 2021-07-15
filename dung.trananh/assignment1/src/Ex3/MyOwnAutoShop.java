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
public class MyOwnAutoShop {
    public static void main(String[] args) {
        Ford f1 = new Ford(2021, 10, 200, 10000, "black");
        Ford f2 = new Ford(2020, 15, 160, 8000, "gray");
        Sedan s = new Sedan(50, 180, 5000, "white");
        Car c = new Car(180, 7000, "black");
        System.out.println("All the sale prices for each cars: ");
        System.out.println("-----------------------");
        System.out.println("Ford f1: ");
        System.out.println(f1.getSalePrice());
        System.out.println("-----------------------");
        System.out.println("Ford f2: ");
        System.out.println(f2.getSalePrice());
        System.out.println("-----------------------");
        System.out.println("Sedan s: ");
        System.out.println(s.getSalePrice());
        System.out.println("-----------------------");
        System.out.println("Car c: ");
        System.out.println(c.getSalePrice());
        
    }
}
