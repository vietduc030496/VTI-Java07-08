package entity;

public class Lop {
	private int ID_Lop;
	private String tenlop;
	private String nienkhoa;
	public Lop() {
		super();
	}
	public Lop(int ID_Lop, String tenlop, String nienkhoa) {
		super();
		this.ID_Lop = ID_Lop;
		this.tenlop = tenlop;
		this.nienkhoa = nienkhoa;
	}
	
	public int getId_lop() {
		return ID_Lop;
	}
	public void setId_lop(int ID_Lop) {
		this.ID_Lop = ID_Lop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public String getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	
	@Override
	public String toString() {
		return "\t" + ID_Lop + "\t"  + tenlop + "\t"  + nienkhoa;
	}
}
