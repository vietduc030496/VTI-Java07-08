package entity;

public class BangDiem {
	private int ID_SV;
	private int ID_MonHoc;
	private int diem;

	public BangDiem() {

	}

	public BangDiem(int iD_SV, int iD_MonHoc, int diem) {
		ID_SV = iD_SV;
		ID_MonHoc = iD_MonHoc;
		this.diem = diem;
	}

	public int getID_SV() {
		return ID_SV;
	}

	public void setID_SV(int iD_SV) {
		ID_SV = iD_SV;
	}

	public int getID_MonHoc() {
		return ID_MonHoc;
	}

	public void setID_MonHoc(int iD_MonHoc) {
		ID_MonHoc = iD_MonHoc;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "BangDiem [ID_SV=" + ID_SV + ", ID_MonHoc=" + ID_MonHoc + ", diem=" + diem + "]";
	}

}
