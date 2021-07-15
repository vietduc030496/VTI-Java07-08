package ExerciseThree;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sedan sedan = new Sedan(200,1231.4, "Black",100);
		Ford ford1 = new Ford(300, 3212.3, "Blue", 10, 100);
		Ford ford2 = new Ford(360, 4212.3, "Green", 15, 500);
		Truck truck = new Truck(260, 313321.3, "Purple", 1000);
		System.out.println("sedan price: " + sedan.getSalePrice());
		System.out.println("ford1 price: " + ford1.getSalePrice());
		System.out.println("ford2 price: " + ford2.getSalePrice());
		System.out.println("truck price: " + truck.getSalePrice());
	}

}
