public class Truck extends Car{
    private int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSalePrice() {
        if(this.getWeight() > 2000) return 0.9 * this.getRegularPrice();
        else return 0.8 * this.getRegularPrice();
    }
}
