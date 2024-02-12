package Controller;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Courses;
import Model.Student;


public class StudentDao {
	private String dbUrl = "jdbc:postgresql://localhost:5432/Testing";
	private String username = "postgres";
	private String pwd = "1974";
	public StudentDao() {
		super();
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found");
            e.printStackTrace();
        }
	}
	
	public String addStudent (Student studObj) {
		try {
			
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			//Statement st = con.createStatement();
			String sql = "insert into students(student_id,first_name,last_name) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, studObj.getStudent_id());
			pst.setString(2, studObj.getFirst_name());
			pst.setString(3, studObj.getLast_name());
			int rowAff = pst.executeUpdate();
			if(rowAff >= 1) {
				con.close();
				return "Student Reccorded";
			}else {
				con.close();
				return "Student not Recorded";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Server Error";
		}
	}
	
	public String updateStudent(Student studentObj) {
		try {
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			//Statement st = con.createStatement();
			String sql = "update students set first_name=?, last_name=? where student_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, studentObj.getFirst_name());
			pst.setString(2, studentObj.getLast_name());
			pst.setString(3, studentObj.getStudent_id());
			int rowAffected = pst.executeUpdate();
			if(rowAffected >= 1) {
				con.close();
				return "Student record updated";
			}else {
				con.close();
				return "Student record not updated";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Servor error";
		}
	}
		
    public String deleteStudent(String studentId) {
	        try (Connection con = DriverManager.getConnection(dbUrl, username, pwd)) {
	            String sql = "delete from students where student_id=?";
	            try (PreparedStatement pst = con.prepareStatement(sql)) {
	                pst.setString(1, studentId);

	                int rowAffected = pst.executeUpdate();
	                if (rowAffected >= 1) {
	                    return "Student deleted";
	                } else {
	                    return "Student not found or not deleted";
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return "Server error";
	        }
    }
	    
    public List<Student> allStudents(){
		try {
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			String sql = "select * from students";
			PreparedStatement pst = con.prepareStatement(sql);
	           ResultSet result = pst.executeQuery();
	           List<Student> studentList = new ArrayList<>();
	           while(result.next()){
	               Student studentObj = new Student();
	               studentObj.setStudent_id(result.getString("student_id"));       // setCourse_code(result.getString("course_code"));   //setBookId(result.getString("book_id"));
	               studentObj.setFirst_name(result.getString("first_name"));   //setCourse_name(result.getString("course_name"));  //  setTitle(result.getString("title"));
	               studentObj.setLast_name(result.getString("last_name"));
	               studentList.add(studentObj); // add(bookObj);
	           }
	           con.close();
	           return studentList;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


