package b3;

public class Sedan extends Car{
	private int length;
	@Override
	public double getSalePrice() {
		if(length>0) {
			if(this.length>20) {
				return this.getRegularPrice()*0.05;
			}else {
				return this.getRegularPrice()*0.1;
			}
		}else {
			return 0;
		}
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Sedan(int length) {
		super();
		this.length = length;
	}
	public Sedan() {
		super();
	}
	
}
