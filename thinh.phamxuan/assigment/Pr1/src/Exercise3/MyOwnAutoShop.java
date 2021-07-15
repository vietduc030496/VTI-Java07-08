package Exercise3;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sedan sedan=new Sedan(30);
		sedan.setRegularPrice(7000);
		System.out.println(sedan.getSalePrice());
		Ford ford1=new Ford(2018,10);
		ford1.setRegularPrice(10000);
		System.out.println(ford1.getSalePrice());
		Ford ford2=new Ford(2021,5);
		ford2.setRegularPrice(15000);
		System.out.println(ford2.getSalePrice());
		Car car=new Car(60,5000,"black");
		System.out.println(car.getSalePrice());
		
		
		
	}

}


	

