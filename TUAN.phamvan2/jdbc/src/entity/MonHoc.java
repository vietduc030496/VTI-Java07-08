package entity;

public class MonHoc {
	private int monhocID;
	private String tenMonHoc;
	private int soTinChi;

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonHoc(int monhocID, String tenMonHoc, int soTinChi) {
		super();
		this.monhocID = monhocID;
		this.tenMonHoc = tenMonHoc;
		this.soTinChi = soTinChi;
	}

	public int getMonhocID() {
		return monhocID;
	}

	public void setMonhocID(int monhocID) {
		this.monhocID = monhocID;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	@Override
	public String toString() {
		return "MonHoc [monhocID=" + monhocID + ", tenMonHoc=" + tenMonHoc + ", soTinChi=" + soTinChi + "]";
	}

}
