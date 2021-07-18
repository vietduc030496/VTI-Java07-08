package Exercise3;

public class Sedan extends Car {
	private int length;
	
	public Sedan() {
		super();
	}
	
	public Sedan(int length) {
		
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getSalePrice() {
		if(this.length>20) {
			return this.getRegularPrice()*0.95;
		}
		else {
			return this.getRegularPrice()*0.9;
		}
	
	};
	
	
}
