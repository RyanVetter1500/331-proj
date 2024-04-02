/*
Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024
This program will allow the user to select various options in regards to a University Management System. 
The user will be able to: 
○ Create and edit Students, Faculty, Courses, and Semesters 
○ Assign Faculty to a Course in a Semester 
○ Enroll of Student in Course in a Semester 
○ Create various reports while prompting for user input 
    ○ Print Courses in a Semester
    ○ Print all Courses taught by Faculty member in Semester
	○ Show all Courses a Student is in for a Semester
	○ Show all Students enrolled in a single Course in a Semester
*/

import java.util.*;

public class SystemManagementApp {

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        int x = 2;
        Student[] studentArray = new Student[100];
        Faculty[] facultyArray = new Faculty[100];
        Courses[] courseArry = new Courses[100];
        Semester[] semesterArray = new Semester[100];
        while (x > 1)
        {
            System.out.println("Please choose an option from the following by typing in the corresponding number:");
            System.out.println("1 - Create a Student, Faculty, Course, or Semester");
            System.out.println("2 - Assign a Faculty Member to a Course");
            System.out.println("3 - Enroll a Student in a Course");
            System.out.println("4 - Print Report");
            System.out.println("5 - Show Info");
            System.out.println("6 - Exit Application");
            System.out.println("Enter Selection:");
            int selection = keyIn.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    



                    break;
                case 2:





                    break;
                case 3:
                




                    break;
                case 4:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");




                    break;
                case 5:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");




                    break;

                case 6:
                    x = 0;
                    break;
                default:
                    System.out.println("Please Enter a Valid Selection");


            }
        }



    }

    public String printSemCourses() {

    }

    public String printFacultyCourses() {

    }

    public String studentCourses() {

    }

    public String courseStudents() {

    }
    
}
