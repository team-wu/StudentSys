package entity;

public class CourseEntity {
	private int id;
	private String name;
	private String credit;
	private String time;
	private String desc;
	private Integer type;
	private Integer academyId;
	
	
	public Integer getAcademyId() {
		return academyId;
	}
	public void setAcademyId(Integer academyId) {
		this.academyId = academyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

}
