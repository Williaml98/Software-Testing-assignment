package View;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Controller.CoursesDao;
import Controller.StudentDao;
import Model.Courses;
import Model.Student;

public class UI {
	public static void  main(String[] args) {
		boolean cond = true;
		String studentId;
		String firstName;
		String lastName;
		String coursecode;
		String courseName;
		String credit;
		//String times;
		
		Student stud = new Student();
		Courses cour = new Courses();
		
		while(cond) {
			System.out.println("============================");
			System.out.println("STUDENT & COURSES MANAGEMENT");
			System.out.println("----------------------------");
			
			System.out.println("1. Register Student ");
			System.out.println("2. Register Course");
			System.out.println("3. Update Student ");
			System.out.println("4. Update Course ");
			System.out.println("5. Delete Student ");
			System.out.println("6. Delete Course ");
			System.out.println("7. Retrieve All Students  ");
			System.out.println("8. Retrieve All Courses ");
			//System.out.println("9. Search Student by ID ");
			//System.out.println("10. Search Course by ID ");
			System.out.println("0. Exit ");
			System.out.println("------------------------ ");
			System.out.print("Choose: ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Student ID");
				studentId = input.next();
				System.out.println("Enter First Name");
				firstName = input.next();
				System.out.println("Enter Last Name");
				lastName = input.next();
				
				stud.setStudent_id(studentId);
				stud.setFirst_name(firstName);
				stud.setLast_name(lastName);
				
				StudentDao dao = new StudentDao();
				String feedback = dao.addStudent(stud);
				System.out.println(feedback);
				System.out.println("Do you wish to continue?, yes or no ");
				String answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using the system");
					cond = false;
				}
				break;
			case 2:
				System.out.println("Enter Course code");
				coursecode = input.next();
				System.out.println("Enter Course name");
				courseName = input.next();
				System.out.println("Enter Course Credits");
				credit = input.next();
				
				cour.setCourse_code(coursecode);
				cour.setCourse_name(courseName);
				cour.setCredits(credit);
				
				CoursesDao courdao = new CoursesDao();
				String feedBack = courdao.addCourse(cour);
				System.out.println(feedBack);
				System.out.println("Do you wish to continue?, yes or no ");
				String answers = input.next();
				if(answers.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using the system");
					cond = false;
				}
				break;
			case 3:
			    System.out.println("Enter Student ID");
			    studentId = input.next();
			    System.out.println("Enter First Name");
			    firstName = input.next();
			    System.out.println("Enter Last Name");
			    lastName = input.next();

			    Student theStudent = new Student();
			    theStudent.setStudent_id(studentId);
			    theStudent.setFirst_name(firstName);
			    theStudent.setLast_name(lastName);

			    StudentDao daos = new StudentDao();
			    String feedbacks = daos.updateStudent(theStudent);
			    System.out.println(feedbacks);
			    System.out.println("Do you wish to continue?, yes or no ");
			    String answe = input.next();
			    if (answe.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			case 4:
			    System.out.println("Enter Course code");
			    coursecode = input.next();
			    System.out.println("Enter Course name");
			    courseName = input.next();
			    System.out.println("Enter Course Credits");
			    credit = input.next();

			    cour.setCourse_code(coursecode);
			    cour.setCourse_name(courseName);
			    cour.setCredits(credit);

			    CoursesDao courdaos = new CoursesDao();
			    String feedBacks = courdaos.updateCourse(cour);
			    System.out.println(feedBacks);
			    System.out.println("Do you wish to continue?, yes or no ");
			    String answerss = input.next();
			    if (answerss.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			case 5:
		        // Code for deleting a student
		        System.out.println("Enter Student ID to delete:");
		        studentId = input.next();
		        StudentDao studentDao = new StudentDao();
		        String deleteFeedback = studentDao.deleteStudent(studentId);
		        System.out.println(deleteFeedback);
		        break;
			case 6:
				System.out.println("Enter Course code to delete");
		        coursecode = input.next();
		        CoursesDao courseDao = new CoursesDao();
		        String deleteFeedbacks = courseDao.deleteCourse(coursecode);
		        System.out.println(deleteFeedbacks);
		        break;
			case 8:
			    CoursesDao daoss = new CoursesDao();
			    List<Courses> courses = daoss.allCourses();
			    int counter = 0;
			   // Iterator iterator = courses.iterator();
			    if(courses != null) {
			    // Iterate over the courses and print their details
			    for (Courses coursObj : courses) {
			        counter++;
			        System.out.println("Course " + counter);
			        System.out.println("---------");
			        System.out.println("Course code: " + coursObj.getCourse_code());
			        System.out.println("Course name: " + coursObj.getCourse_name());
			        System.out.println("Credits: " + coursObj.getCredits());
			    }
			    }
			    break;
			case 7:
			   StudentDao daostud = new StudentDao();
			   List<Student> students = daostud.allStudents();
			   int counters = 0;
			   if(students != null) {
				   for(Student studentObj : students) {
					   counters++;
					   System.out.println("Student " + counters);
				       System.out.println("---------");
				       System.out.println("Student ID: " + studentObj.getStudent_id());
				       System.out.println("First name: " + studentObj.getFirst_name());
				       System.out.println("Last name: " + studentObj.getLast_name());   
				   }
			   }
			   
			    break;
		    case 0:
		        cond = false;
		        System.out.println("Thank you for using the system");
		        break;
		    default:
		        System.out.println("Invalid choice, please try again");
				
			}
			
			
		}
	}

}
