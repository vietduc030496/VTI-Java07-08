package Bai3;

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sd= new Sedan(100, 3000.0, "Violet", 15);
//        sd.setSpeed(100);
//        sd.setRegularPrice(3000.0);
//        sd.setColor("Violet");
//        sd.setLength(15);

        Ford f1= new Ford(90,2700.0,"Black",2020,700);
//        f1.setSpeed(90);
//        f1.setRegularPrice(2700.0);
//        f1.setColor("Black");
//        f1.setYear(2020);
//        f1.setManufacturerDiscount(700);

        Ford f2= new Ford(95,3400.0,"White",2021,450);
//        f2.setSpeed(95);
//        f2.setRegularPrice(3400.0);
//        f2.setColor("White");
//        f2.setYear(2021);
//        f2.setManufacturerDiscount(450);
        Car car= new Car(80,2900.0,"Blue");
        System.out.println("Thong tin ve gia ban cua tat ca cac xe:\n");
        System.out.println("Sedan: "+ sd.getSalePrice() + "\n" );
        System.out.println("Ford1: "+ f1.getSalePrice() + "\n");
        System.out.println("Ford2: "+ f2.getSalePrice() + "\n");
        System.out.println("Car: "+ car.getSalePrice() + "\n");
    }
}
