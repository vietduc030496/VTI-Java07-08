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
public class MyOwnAutoShop {

    public static void main(String[] args) {
        Sedan sedan = new Sedan(19, 200, 150000, "blue");
        Ford ford = new Ford(2, 20000, 150, 160000, "blue");
        Car car = new Car(123, 130000, "blue");
        System.out.println("Sale price of sedan : " + sedan.getSalePrice());
        System.out.println("Sale price of Ford : " + ford.getSalePrice());
        System.out.println("Sale price of card : " + car.getSalePrice());

    }
}
