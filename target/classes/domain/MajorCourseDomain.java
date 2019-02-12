package domain;

import java.util.List;

public class MajorCourseDomain {
	private Integer id;
	private Integer major_id;
	private Integer course_id;
	private List<Integer> courseIds;
	private Integer school_year;
	private Integer term;
	private String majorName;
	private String courseName;
	
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
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
	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}
	public List<Integer> getCourseIds() {
		return courseIds;
	}
	

}
