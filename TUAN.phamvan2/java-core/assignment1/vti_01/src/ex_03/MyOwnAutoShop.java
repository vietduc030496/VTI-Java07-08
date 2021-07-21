package ex_03;

public class MyOwnAutoShop {
	public static void main(String[] args) {
		Sedan sedan1  = new Sedan(22);
		sedan1.setRegularPrice(20000);
		Ford ford1 = new Ford(2020, 40);
		ford1.setRegularPrice(30000);
		Ford ford2 = new Ford(2021, 10);
		ford2.setRegularPrice(25000);
		Car car = new Car(200, 30000.0, "red");
		System.out.println("sedan1: " + sedan1.getSalePrice());
		System.out.println("ford1: " + ford1.getSalePrice());
		System.out.println("ford2: " + ford2.getSalePrice());
	}
}
