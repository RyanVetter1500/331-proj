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
        int studentEnrollmentCount = 0;
        int facultyEnrollmentCount = 0;
        
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
                    switch (selection)
                    {
                        case 1: createStudent(studentArray, studentCount);
                        studentCount++;
                        break;
                        case 2: createFaculty(facultyArray, facultyCount);
                        facultyCount++;
                        break;
                        case 3: createCourse(courseArray, courseCount);
                        courseCount++;
                        break;
                        case 4: createSemester(semesterArray, semesterCount);
                        semesterCount++;
                        break;
                        default: System.out.println("Please enter a valid selection");
                        break;
                    }



                    break;
                case 2:
                    enrollFaculty(facultyEnrollmentArray, facultyEnrollmentCount);
                    facultyEnrollmentCount++;
                    break;




                    
                case 3:
                    enrollStudent(studentEnrollmentArray, studentEnrollmentCount);
                    studentEnrollmentCount++;




                    break;
                case 4:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("1 - Print all Courses taught in a Semester");
                    System.out.println("2 - Print all Courses taught by a Faculty member");
                    int printSelection = keyIn.nextInt();
                    switch (printSelection) {
                        case 1:
                            System.out.println("Enter the Semester period (Fall, Spring, Summer)");
                            String periodSelection = keyIn.nextLine();
                            System.out.println("Enter the Semester year (20XX)");
                            String yearSelection = keyIn.next();
                            //System.out.print(printSemCourses(periodSelection, yearSelection));
                            break;
                        
                        case 2:
                            //printFacultyCourses();
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
    
    
    public static void createStudent(Student[] studentArray, int studentCount)
    {
        Scanner in = new Scanner(System.in);
        //student has user enter in all data fields and creates class for student 
        System.out.println("Please enter Student Name:");
        String name = in.nextLine();

        System.out.println("Please enter Student SSN (Dont seperate with any characters):");
        int ssn = in.nextInt();

        System.out.println("Please enter Student Student ID:");
        int studentID = in.nextInt();

        System.out.println("Please enter Student Address:");
        String address = in.nextLine();
        in.next();

        System.out.println("Please enter Student Email:");
        String email = in.nextLine();
        in.next();

        System.out.println("Please enter Student GPA:");
        double GPA = in.nextDouble();

        System.out.println("Please enter Student emergency contact Name:");
        String contactName = in.nextLine();
        in.next();

        System.out.println("Please enter Student emergency contact Phone #:");
        String contactNum = in.nextLine();
        in.next();

        System.out.println("Please enter Student emergency contact address:");
        String contactAddress = in.nextLine();
        in.next();

        String[] contactList = {contactName, contactNum, contactAddress};

        Student s1 = new Student(name, ssn, studentID, address, email, GPA, contactList);
        studentArray[studentCount] = s1;
    }
    
    public static void createFaculty(Faculty[] facultyArray, int facultyCount)
    {
        Scanner in = new Scanner(System.in);
        //faculty has user enter in all data fields and creates class for faculty 
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();

        System.out.println("Please enter Faculty Name:");
        String emplName = in.nextLine();
        in.next();

        System.out.println("Please enter Faculty email:");
        String emplEmail  = in.nextLine();
        in.next();

        System.out.println("Please enter Faculty building:");
        String building = in.nextLine();
        in.next();

        System.out.println("Please enter Faculty Office Number:");
        int officeNum = in.nextInt();

        System.out.println("Please enter employee phone number:");
        String emplPhone = in.nextLine();
        in.next();

        System.out.println("Please enter Faculty Department:");
        String dept = in.nextLine();
        in.next();

        System.out.println("Please enter Faculty Position:");
        String position = in.nextLine();
        in.next();

        Faculty f1 = new Faculty(facultyID, emplName, emplEmail, building, officeNum, emplPhone, dept, position); 
        facultyArray[facultyCount] = f1;
    }
    
    public static void createSemester(Semester[] semesterArray, int semesterCount)
    {
        //semester has user enter in all data fields and creates class for semester     
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter semester period (Fall, Spring, Summer):");
        String period = in.nextLine();
        
        System.out.println("Please enter semester year:");
        int year = in.nextInt();
        
        Semester semester1 = new Semester(period, year);
        semesterArray[semesterCount] = semester1;
        
    }
    public static void createCourse(Course[] courseArray, int courseCount)
    {
        Scanner in = new Scanner(System.in);
        //course has user enter in all data fields and creates class for course              
        System.out.println("Please enter course prefix");
        String prefix = in.next();
        
        System.out.println("Please enter course number");
        int courseNum = in.nextInt();
        
        System.out.println("Please enter course name");
        String courseName = in.nextLine();
        in.next();
        
        System.out.println("Please enter course days");
        int days = in.nextInt();
        
        System.out.println("Please enter course time start");
        String timeStart = in.nextLine();
        in.next();
        
        System.out.println("Please enter course time end");
        String timeEnd = in.nextLine();
        in.next();
        
        System.out.println("Please enter course credit hours");
        int creditHr = in.nextInt();


        Course c1 = new Course(prefix, courseNum, courseName, days, timeStart, timeEnd, creditHr);     
        courseArray[courseCount] = c1;
                
    }
    
    
        
    
    

   /* public static String printSemCourses(Semester[] semesterArray) 
    {
        System.out.println("=============================");
        String semesterList = "";
        for (int i = 0; i < semesterArray.length; i++)
        {
            
        }

        return listOfSemesterCourses;
    }

    public String printFacultyCourses() {

    }

    public String studentCourses() {

    }

    public String courseStudents() {

    }*/
    
    public static void enrollStudent(Enrollment[] studentEnrollmentArray, int studentEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Student ID:");
        int studentID = in.nextInt();
        
        System.out.println("Please enter course number:");
        int courseNum = in.nextInt();
        
        System.out.println("Please enter semester year:");
        int semesterYear = in.nextInt();
        
        System.out.println("Please eneter semester period:");
        String semesterPeriod = in.nextLine();
        in.next();

        Enrollment e1 = new Enrollment(studentID, courseNum, semesterYear, semesterPeriod);
        studentEnrollmentArray[studentEnrollmentCount] = e1;
    }
    
    public static void enrollFaculty(Enrollment[] facultyEnrollmentArray, int facultyEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();
        
        System.out.println("Please enter course number:");
        int courseNum = in.nextInt();
        
        System.out.println("Please enter semester year:");
        int semesterYear = in.nextInt();
        
        System.out.println("Please eneter semester period:");
        String semesterPeriod = in.nextLine();
        in.next();
        
        Enrollment e1 = new Enrollment(facultyID, courseNum, semesterYear, semesterPeriod);
        facultyEnrollmentArray[facultyEnrollmentCount] = e1;
    }
    
    
    //public static void printSemCourses()
    
    
    
    
}

