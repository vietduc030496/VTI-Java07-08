package ToolJDBC.entity;

import java.sql.Date;

public class SinhVien {
	private int ID_SV ;
	private String HoLot;
	private String Ten;
	private String GioiTinh;
	private String NgaySinh;
	private String DiaChi;
	private String DienThoai;
	private String Email ;
	private String ID_Lop;
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(int iD_SV, String hoLot, String ten, String gioiTinh, String ngaySinh, String diaChi,
			String dienThoai, String email, String iD_Lop) {
		super();
		ID_SV = iD_SV;
		HoLot = hoLot;
		Ten = ten;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		DienThoai = dienThoai;
		Email = email;
		ID_Lop = iD_Lop;
	}
	public int getID_SV() {
		return ID_SV;
	}
	public void setID_SV(int iD_SV) {
		ID_SV = iD_SV;
	}
	public String getHoLot() {
		return HoLot;
	}
	public void setHoLot(String hoLot) {
		HoLot = hoLot;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh.toString();
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getID_Lop() {
		return ID_Lop;
	}
	public void setID_Lop(String iD_Lop) {
		ID_Lop = iD_Lop;
	}
	@Override
	public String toString() {
		return "SinhVien [ID_SV=" + ID_SV + ", HoLot=" + HoLot + ", Ten=" + Ten + ", GioiTinh=" + GioiTinh
				+ ", NgaySinh=" + NgaySinh + ", DiaChi=" + DiaChi + ", DienThoai=" + DienThoai + ", Email=" + Email
				+ ", ID_Lop=" + ID_Lop + "]";
	}
	
	
	
}
