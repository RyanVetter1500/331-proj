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

package project;

import java.util.*;

public class SystemManagementApp {

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        int x = 2;
        Student[] studentArray = new Student[100];
        Faculty[] facultyArray = new Faculty[100];
        Course[] courseArray = new Course[100];
        Semester[] semesterArray = new Semester[100];
        Enrollment[] studentEnrollmentArray = new Enrollment[100];
        Enrollment[] facultyEnrollmentArray = new Enrollment[100];
        
        int studentCount = 0;
        int facultyCount = 0;
        int courseCount = 0;
        int semesterCount = 0;
        
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
                    System.out.println("Create: \n1. Student \n2. Faculty \n3. Course \n4. Semester");
                    selection = keyIn.nextInt();
                    createRecord(selection);
                    



                    break;
                case 2:
                    enrollFaculty();




                    break;
                case 3:
                    enrollStudent();




                    break;
                case 4:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("1 - Print all Courses taught in a Semester");
                    System.out.println("2 - Print all Courses taught by a Faculty member");
                    int printSelection = keyIn.nextInt();
                    switch (printSelection) {
                        case 1:
                            
                            break;
                        
                        case 2:
                            
                            break;
                    }



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
    
    public static void createRecord(int selection)
    {
        
        Scanner in = new Scanner(System.in);
        switch (selection)
        {
            case 1: //student has user enter in all data fields and creates class for student 
                System.out.println("Please enter Student Name:");
                String name = in.nextLine();
                
                System.out.println("Please enter Student SSN (Dont seperate with any characters):");
                int ssn = in.nextInt();
                
                System.out.println("Please enter Student Student ID:");
                int studentID = in.nextInt();
                
                System.out.println("Please enter Student Address:");
                String address = in.nextLine();
                
                System.out.println("Please enter Student Email:");
                String email = in.nextLine();
                
                System.out.println("Please enter Student GPA:");
                double GPA = in.nextDouble();
                
                System.out.println("Please enter Student emergency contact Name:");
                String contactName = in.nextLine();
                
                System.out.println("Please enter Student emergency contact Phone #:");
                String contactNum = in.nextLine();
                
                System.out.println("Please enter Student emergency contact address:");
                String contactAddress = in.nextLine();
                
                String[] contactList = {contactName, contactNum, contactAddress};
                
                Student s1 = new Student(name, ssn, studentID, address, email, GPA, contactList);
                break;
                
            case 2: //faculty has user enter in all data fields and creates class for faculty 
                System.out.println("Please enter Faculty ID:");
                int facultyID = in.nextInt();
                
                System.out.println("Please enter Faculty Name:");
                String emplName = in.nextLine();
                
                System.out.println("Please enter Faculty email:");
                String emplEmail  = in.nextLine();
                
                System.out.println("Please enter Faculty building:");
                String building = in.nextLine();
                
                System.out.println("Please enter Faculty Office Number:");
                int officeNum = in.nextInt();
                
                System.out.println("Please enter employee phone number:");
                String emplPhone = in.nextLine();
                
                System.out.println("Please enter Faculty Department:");
                String dept = in.nextLine();
                
                System.out.println("Please enter Faculty Position:");
                String position = in.nextLine();
                
                Faculty f1 = new Faculty(facultyID, emplName, emplEmail, building, officeNum, emplPhone, dept, position);
                break;
              
            case 3: //course has user enter in all data fields and creates class for course              
                System.out.println("Please enter course prefix");
                String prefix = in.next();
                System.out.println("Please enter course number");
                int courseNum = in.nextInt();
                System.out.println("Please enter course name");
                String courseName = in.nextLine();
                System.out.println("Please enter course days");
                int days = in.nextInt();
                System.out.println("Please enter course time start");
                String timeStart = in.nextLine();
                System.out.println("Please enter course time end");
                String timeEnd = in.nextLine();
                System.out.println("Please enter course credit hours");
                int creditHr = in.nextInt();
                
                
                Course c1 = new Course(prefix, courseNum, courseName, days, timeStart, timeEnd, creditHr);
                break;
                
               
            case 4: //semester has user enter in all data fields and creates class for semester
                
                System.out.println("Please enter semester period (Fall, Spring, Summer):");
                String period = in.nextLine();
                System.out.println("Please enter semester year:");
                int year = in.nextInt();
                
                Semester semester1 = new Semester(period, year);
                break;
                
                
                
            default: System.out.println("Please enter a valid selection");
            break;
        }
        
    }
    

    public String printSemCourses() 
    {
        String enrollmentList = "";
        for (int i = 0; i < enrollmentArray.length: i++)
        {
            
        }
    }

    public String printFacultyCourses() {

    }

    public String studentCourses() {

    }

    public String courseStudents() {

    }
    
    public static void enrollStudent()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Student ID:");
        int studentID = in.nextInt();
        
        System.out.println("Please enter course number:");
        int courseNum = in.nextInt();
        
        System.out.println("Please enter semester:");
        int semester = in.nextInt();
        
        Enrollment e1 = new Enrollment(studentID, courseNum, semester);
    }
    
    public static void enrollFaculty()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();
        
        System.out.println("Please enter course number:");
        int courseNum = in.nextInt();
        
        System.out.println("Please enter semester:");
        int semester = in.nextInt();
        
        Enrollment e1 = new Enrollment(facultyID, courseNum, semester);
    }
    
    
    
    
}