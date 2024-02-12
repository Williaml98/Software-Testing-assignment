package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Courses;
import Model.Student;

public class CoursesDao {
	private String dbUrl = "jdbc:postgresql://localhost:5432/Testing";
	private String username = "postgres";
	private String pwd = "1974";
	
	public CoursesDao() {
		super();
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found");
            e.printStackTrace();
        }
	}
	
	public String addCourse(Courses courseObj) {
		try {
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			//Statement st = con.createStatement();
			String sql = "insert into courses(course_code,course_name,credits) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, courseObj.getCourse_code());
			pst.setString(2, courseObj.getCourse_name());
			pst.setString(3, courseObj.getCredits());
			//pst.setTime(4, courseObj.getTime());
			int rowAffected = pst.executeUpdate();
			if(rowAffected >= 1) {
				con.close();
				return "Course added";
			}else {
				con.close();
				return "Course not added";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Server error";
		}
		
	}
	
	public String updateCourse(Courses courseObj) {
		try {
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			//Statement st = con.createStatement();
			String sql = "update courses set course_name=?, credits=? where course_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, courseObj.getCourse_name());
			pst.setString(2, courseObj.getCredits());
			pst.setString(3, courseObj.getCourse_code());
			int rowAffected = pst.executeUpdate();
			if(rowAffected >= 1) {
				con.close();
				return "Course record updated";
			}else {
				con.close();
				return "Course record not updated";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Servor error";
		}
	}
	
	public String deleteCourse(String courseCode) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, pwd)) {
            String sql = "delete from courses where course_code=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, courseCode);

                int rowAffected = pst.executeUpdate();
                if (rowAffected >= 1) {
                    return "Course deleted";
                } else {
                    return "Course not found or not deleted";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Server error";
        }
    }
	
//	 public List<Courses> displayAllCourses() {
//	        List<Courses> coursesList = new ArrayList<>();
//	        try (Connection con = DriverManager.getConnection(dbUrl, username, pwd)) {
//	            String sql = "select * from courses";
//	            try (PreparedStatement pst = con.prepareStatement(sql)) {
//	                try (ResultSet rs = pst.executeQuery()) {
//	                    while (rs.next()) {
//	                        Courses course = new Courses();
//	                        course.setCourse_code(rs.getString("course_code"));
//	                        course.setCourse_name(rs.getString("course_name"));
//	                        course.setCredits(rs.getString("credits"));
//	                        coursesList.add(course);
//	                    }
//	                }
//	            }
//	        } catch (Exception ex) {
//	            ex.printStackTrace();
//	        }
//	        return coursesList;
    


	
	public List<Courses> allCourses(){
		try {
			Connection con = DriverManager.getConnection(dbUrl, username,pwd);
			String sql = "select * from courses";
			PreparedStatement pst = con.prepareStatement(sql);
	           ResultSet result = pst.executeQuery();
	           List<Courses> courseList = new ArrayList<>();
	           while(result.next()){
	               Courses coursObj = new Courses();
	               coursObj.setCourse_code(result.getString("course_code"));   //setBookId(result.getString("book_id"));
	               coursObj.setCourse_name(result.getString("course_name"));  //  setTitle(result.getString("title"));
	               coursObj.setCredits(result.getString("credits"));
	               courseList.add(coursObj); // add(bookObj);
	           }
	           con.close();
	           return courseList;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
