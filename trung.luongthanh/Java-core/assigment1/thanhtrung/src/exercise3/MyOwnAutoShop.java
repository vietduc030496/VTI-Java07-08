package exercise3;

public class MyOwnAutoShop {
	public static void main(String[] args) {
		Sedan sedan = new Sedan(80, 1000, "yellow", 21);
		Ford ford = new Ford(100, 1200, "red", 2021, 100);
		Car car = new Car(50, 50000, "black");

		System.out.println("Sedan co gia " + sedan.getSalePrice() + " $");
		System.out.println("Ford co gia " + ford.getSalePrice() + " $");
		System.out.println(car.getSalePrice());
	}
}
