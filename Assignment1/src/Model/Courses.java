package Model;

import java.sql.Time;

public class Courses {
	private String course_code;
	private String course_name;
	private String credits;
	private Time time;
	public Courses() {
		super();
	}
	public Courses(String course_code, String course_name, String credits, Time time) {
		super();
		this.course_code = course_code;
		this.course_name = course_name;
		this.credits = credits;
		this.time = time;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	

}
