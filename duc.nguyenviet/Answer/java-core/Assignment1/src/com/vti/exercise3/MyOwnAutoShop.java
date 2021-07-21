package com.vti.exercise3;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		Sedan sedan = new Sedan(80, 1_200, "white", 21);
		Ford ford = new Ford(100, 1_000, "red", 2021, 100);
		Car car = new Car(50, 500, "black");

		System.out.println("Sedan co gia " + sedan.getSalePrice() + " VND");
		System.out.println("Ford co gia " + ford.getSalePrice() + " VND");
		System.out.println(car.getSalePrice());
	}

}
