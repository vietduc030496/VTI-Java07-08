package b3;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		
		Sedan sedan = new Sedan(100);
		sedan.setRegularPrice(15000);
		Ford ford1= new Ford(1999, 10);
		ford1.setRegularPrice(20000);
		Ford ford2= new Ford(2000,50);
		ford2.setRegularPrice(25000);
		Car car = new Car(100, 10000, "xanh");
		
		System.out.println("sedan: "+sedan.getSalePrice());
		System.out.println("ford1: "+ford1.getSalePrice());
		System.out.println("ford2: "+ford2.getSalePrice());
		System.out.println("car: "+car.getSalePrice());
	}

}
