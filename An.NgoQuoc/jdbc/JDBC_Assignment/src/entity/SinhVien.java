package entity;

import java.sql.Date;

public class SinhVien {
	private int ID_SV;
	private String holot;
	private String ten;
	private int gioitinh;
	private Date ngaysinh;
	private String dienthoai;
	private String email;
	private int ID_Lop;
	public int getID_SV() {
		return ID_SV;
	}
	public void setID_SV(int iD_SV) {
		ID_SV = iD_SV;
	}
	public String getHolot() {
		return holot;
	}
	public void setHolot(String holot) {
		this.holot = holot;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getID_Lop() {
		return ID_Lop;
	}
	public void setID_Lop(int iD_Lop) {
		ID_Lop = iD_Lop;
	}
	
	@Override
	public String toString() {
		return "\t" + ID_SV + "\t"  + holot + " " + ten + "\t"  + gioitinh + "\t"  + ngaysinh +"\t"  + dienthoai + "\t"  + email + "\t"  + ID_Lop;
	}
}
