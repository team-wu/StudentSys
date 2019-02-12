package entity;

public class StudentEntity {
	private Integer id;
	private String name;
	private Integer gender;
	private String birthday;
	private String tellphone;
	private String email;
	private String description;
	private Integer schoolTerm;
	private Integer schoolYear;
	private Integer majorId;
	private String majorName;
	
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSchoolTerm() {
		return schoolTerm;
	}
	public void setSchoolTerm(Integer schoolTerm) {
		this.schoolTerm = schoolTerm;
	}
	public Integer getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

}
