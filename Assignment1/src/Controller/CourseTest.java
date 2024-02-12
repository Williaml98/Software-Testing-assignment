package Controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Model.Courses;
import Model.Student;

public class CourseTest {

	@Test
	public void testAddCourse() {
        Courses courseToAdd = new Courses();
        courseToAdd.setCourse_code("INSY50");//     setStudent_id("2");
        courseToAdd.setCourse_name("WEB");//  setFirst_name("Therese");
        courseToAdd.setCredits("4");// setLast_name("Lutwamuzire");

        CoursesDao courseDao = new CoursesDao();
        String addResult = courseDao.addCourse(courseToAdd);//   addStudent(studentToAdd);

        assertEquals("Course added", addResult);
    }
	
	@Test
    public void testUpdateCourse() {
		Courses courseToAdd = new Courses();
		CoursesDao courseDao = new CoursesDao();
        Courses thecourse = new Courses();
        thecourse .setCourse_code("INSY50");//    setStudent_id("2");
        thecourse .setCourse_name("Testing");// setFirst_name("Thethe");
        thecourse .setCredits("3");// setLast_name("L");
        String rs = courseDao.updateCourse(thecourse);//   updateStudent(theStudent);

        assertEquals("Course record updated", rs);
    }

	
	@Test
	 public void testDeleteCourse() {
		 CoursesDao courseDao = new CoursesDao();
	    // Student theStudent = new Student();
	     //theStudent.setStudent_id("24423");
	     String rs = courseDao.deleteCourse("INSY50");
	    // String rs = studentDao.deleteStudent("theStudent");
	     assertEquals("Course deleted", rs);
	     
	 }
	
	 @Test
	 public void testAllCourses() {
		 CoursesDao courseDao = new CoursesDao();
		 List<Courses> courseList = courseDao.allCourses();
		 assertNotNull(courseList);
		 assertTrue(courseList.size()>0);
	 }
	
}
