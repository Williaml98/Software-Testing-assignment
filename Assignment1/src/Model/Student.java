package Model;

public class Student {
	private String student_id;
	private String first_name;
	private String last_name;
	public Student() {
		super();
	}
	public Student(String student_id, String first_name, String last_name) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	

}