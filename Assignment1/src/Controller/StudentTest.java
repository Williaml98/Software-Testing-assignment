package Controller;

import static org.junit.Assert.*;

import java.util.List;

import Model.Student;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testAddStudent() {
        Student studentToAdd = new Student();
        studentToAdd.setStudent_id("2");
        studentToAdd.setFirst_name("Therese");
        studentToAdd.setLast_name("Lutwamuzire");

        StudentDao studentDao = new StudentDao();
        String addResult = studentDao.addStudent(studentToAdd);

        assertEquals("Student Reccorded", addResult);
    }
	
	 @Test
	    public void testUpdateStudent() {
	        StudentDao studentDao = new StudentDao();
	        Student theStudent = new Student();
	        theStudent.setStudent_id("2");
	        theStudent.setFirst_name("Thethe");
	        theStudent.setLast_name("L");
	        String rs = studentDao.updateStudent(theStudent);

	        assertEquals("Student record updated", rs);
	    }
	 
	 
	 @Test
	 public void testDeleteStudent() {
		 StudentDao studentDao = new StudentDao();
	     Student theStudent = new Student();
	     //theStudent.setStudent_id("24423");
	     String rs = studentDao.deleteStudent("24423");
	    // String rs = studentDao.deleteStudent("theStudent");
	     assertEquals("Student deleted", rs);
	     
	 }
	 
	 @Test
	 public void testAllStudents() {
		 StudentDao studentDao = new StudentDao();
		 List<Student> studentList = studentDao.allStudents();
		 assertNotNull(studentList);
		 assertTrue(studentList.size()>0);
	 }
	

}
