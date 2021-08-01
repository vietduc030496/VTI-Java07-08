package entity;

public class MonHoc {
	private int ID_MonHoc;
	private int TenMonHoc;
	private int SoTinChi;

	public MonHoc() {

	}

	public MonHoc(int iD_MonHoc, int tenMonHoc, int soTinChi) {
		ID_MonHoc = iD_MonHoc;
		TenMonHoc = tenMonHoc;
		SoTinChi = soTinChi;
	}

	public int getID_MonHoc() {
		return ID_MonHoc;
	}

	public void setID_MonHoc(int iD_MonHoc) {
		ID_MonHoc = iD_MonHoc;
	}

	public int getTenMonHoc() {
		return TenMonHoc;
	}

	public void setTenMonHoc(int tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}

	public int getSoTinChi() {
		return SoTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		SoTinChi = soTinChi;
	}

	@Override
	public String toString() {
		return "MonHoc [ID_MonHoc=" + ID_MonHoc + ", TenMonHoc=" + TenMonHoc + ", SoTinChi=" + SoTinChi + "]";
	}

}
