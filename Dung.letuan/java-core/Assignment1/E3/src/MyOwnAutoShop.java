public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan s = new Sedan(100, 1000, "blue", 30);
        Ford f1 = new Ford(110, 1100.12, "red", 2021, 13);
        Ford f2 = new Ford(90, 1200.34, "green", 2021, 14);
        Car c = new Car(200, 500, "while");
        System.out.println("Sedan s : " + String.format("%.2f", s.getSalePrice()));
        System.out.println("Ford f1 : " + String.format("%.2f", f1.getSalePrice()));
        System.out.println("Ford f2 : " + String.format("%.2f", f1.getSalePrice()));
        System.out.println("Car c : " + String.format("%.2f", c.getSalePrice()));
    }
}
