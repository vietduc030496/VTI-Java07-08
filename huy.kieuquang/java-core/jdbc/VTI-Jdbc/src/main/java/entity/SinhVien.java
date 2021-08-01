package entity;

public class SinhVien {
	private int ID_SV;
	private String hoLot;
	private String ten;
	private String gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String dienThoai;
	private String email;
	private int ID_Lop;

	public SinhVien() {

	}

	public SinhVien(int iD_SV, String hoLot, String ten, String gioiTinh, String ngaySinh, String diaChi,
			String dienThoai, String email, int iD_Lop) {
		ID_SV = iD_SV;
		this.hoLot = hoLot;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		ID_Lop = iD_Lop;
	}
	
	public SinhVien( String hoLot, String ten, String gioiTinh, String ngaySinh, String diaChi,
			String dienThoai, String email, int iD_Lop) {
		this.hoLot = hoLot;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		ID_Lop = iD_Lop;
	}

	public int getID_SV() {
		return ID_SV;
	}

	public void setID_SV(int iD_SV) {
		ID_SV = iD_SV;
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

	public int getID_Lop() {
		return ID_Lop;
	}

	public void setID_Lop(int iD_Lop) {
		ID_Lop = iD_Lop;
	}

	@Override
	public String toString() {
		return "SinhVien [ID_SV=" + ID_SV + ", hoLot=" + hoLot + ", ten=" + ten + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + "]";
	}

}
