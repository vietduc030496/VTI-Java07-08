public class Sedan extends Car {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public double getSalePrice() {
        if(this.getLength() > 20) return 0.95 * this.getRegularPrice();
        else return 0.9 * this.getRegularPrice();
    }


}
