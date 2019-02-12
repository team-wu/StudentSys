package entity;

public class MajorCourseEntity {
	private Integer id;
	private Integer major_id;
	private Integer course_id;
	private Integer school_year;
	private Integer term;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMajor_id() {
		return major_id;
	}
	public void setMajor_id(Integer majorId) {
		major_id = majorId;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer courseId) {
		course_id = courseId;
	}
	public Integer getSchool_year() {
		return school_year;
	}
	public void setSchool_year(Integer schoolYear) {
		school_year = schoolYear;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	

}
