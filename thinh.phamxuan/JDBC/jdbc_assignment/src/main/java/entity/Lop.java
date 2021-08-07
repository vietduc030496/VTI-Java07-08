package entity;

public class Lop {
	private int ID_Lop;
	private String TenLop;
	private String NienKhoa;
	public Lop() {
		super();
	}
	public Lop(int iD_Lop, String tenLop, String nienKhoa) {
		super();
		ID_Lop = iD_Lop;
		TenLop = tenLop;
		NienKhoa = nienKhoa;
	}
	public int getID_Lop() {
		return ID_Lop;
	}
	public void setID_Lop(int iD_Lop) {
		ID_Lop = iD_Lop;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	public String getNienKhoa() {
		return NienKhoa;
	}
	public void setNienKhoa(String nienKhoa) {
		NienKhoa = nienKhoa;
	}
	@Override
	public String toString() {
		return "Lop [ID_Lop=" + ID_Lop + ", TenLop=" + TenLop + ", NienKhoa=" + NienKhoa + "]";
	}
	
}
