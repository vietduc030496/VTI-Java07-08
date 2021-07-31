package entity;

public class Lop {

	private Long id;
	private String name;
	private String year;
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Lop(long id, String name, String year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	public Lop() {
		super();
	}
	
}
