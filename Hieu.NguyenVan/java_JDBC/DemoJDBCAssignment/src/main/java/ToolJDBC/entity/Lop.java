package ToolJDBC.entity;

public class Lop {
	private int ID_Lop;
	private String TenLop;
	private String Nienkhoa ;
	public Lop(int iD_Lop, String tenLop, String nienkhoa) {
		super();
		ID_Lop = iD_Lop;
		TenLop = tenLop;
		Nienkhoa = nienkhoa;
	}
	public Lop() {
		super();
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
	public String getNienkhoa() {
		return Nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		Nienkhoa = nienkhoa;
	}
	
}
