package entity;

import java.util.Date;

public class SinhVien {
	private int svID;
	private String hoLot, ten, gioiTinh;
	private String ngaySinh;
	private String diaChi, dienThoai, email;
	private int lopID;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int svID, String hoLot, String ten, String gioiTinh, String ngaySinh, String diaChi, String dienThoai,
			String email, int lopID) {
		super();
		this.svID = svID;
		this.hoLot = hoLot;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.lopID = lopID;
	}

	public int getSvID() {
		return svID;
	}

	public void setSvID(int svID) {
		this.svID = svID;
	}

	public String getHoLot() {
		return hoLot;
	}

	public void setHoLot(String hoLot) {
		this.hoLot = hoLot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLopID() {
		return lopID;
	}

	public void setLopID(int lopID) {
		this.lopID = lopID;
	}

	@Override
	public String toString() {
		return "SinhVien [svID=" + svID + ", hoLot=" + hoLot + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", email=" + email + ", lopID=" + lopID
				+ "]";
	}

}
