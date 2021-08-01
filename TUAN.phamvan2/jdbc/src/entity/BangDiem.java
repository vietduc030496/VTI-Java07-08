package entity;

public class BangDiem {
	private int svID, monhocID;
	private double diem;

	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangDiem(int svID, int monhocID, double diem) {
		super();
		this.svID = svID;
		this.monhocID = monhocID;
		this.diem = diem;
	}

	public int getSvID() {
		return svID;
	}

	public void setSvID(int svID) {
		this.svID = svID;
	}

	public int getMonhocID() {
		return monhocID;
	}

	public void setMonhocID(int monhocID) {
		this.monhocID = monhocID;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "BangDiem [svID=" + svID + ", monhocID=" + monhocID + ", diem=" + diem + "]";
	}

}
