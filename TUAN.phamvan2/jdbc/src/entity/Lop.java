package entity;

public class Lop {
	private int lopID;
	private String tenLop;
	private String nienKhoa;

	public Lop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lop(int lopID, String tenLop, String nienKhoa) {
		super();
		this.lopID = lopID;
		this.tenLop = tenLop;
		this.nienKhoa = nienKhoa;
	}

	public int getLopID() {
		return lopID;
	}

	public void setLopID(int lopID) {
		this.lopID = lopID;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	@Override
	public String toString() {
		return "Lop [lopID=" + lopID + ", tenLop=" + tenLop + ", nienKhoa=" + nienKhoa + "]";
	}
}
