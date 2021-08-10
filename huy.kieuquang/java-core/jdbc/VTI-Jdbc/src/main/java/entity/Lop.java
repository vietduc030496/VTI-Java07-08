package entity;

public class Lop {
	private int ID_Lop;
	private String tenLop;
	private int nienKhoa;

	public Lop() {

	}

	public Lop(int iD_Lop, String tenLop, int nienKhoa) {
		ID_Lop = iD_Lop;
		this.tenLop = tenLop;
		this.nienKhoa = nienKhoa;
	}

	public int getID_Lop() {
		return ID_Lop;
	}

	public void setID_Lop(int iD_Lop) {
		ID_Lop = iD_Lop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(int nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	@Override
	public String toString() {
		return "Lop [ID_Lop=" + ID_Lop + ", tenLop=" + tenLop + ", nienKhoa=" + nienKhoa + "]";
	}

}
