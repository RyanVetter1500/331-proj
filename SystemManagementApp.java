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
                            String periodSelection = keyIn.next();
                            System.out.println("Enter the Semester year (20XX)");
                            int yearSelection = keyIn.nextInt();
                            
                            printSemCourses(studentEnrollmentArray, courseArray, courseCount, studentEnrollmentCount, periodSelection, yearSelection);
                            break;
                        
                        case 2:
                            
                            System.out.println("Enter Faculty ID");
                            int facultySelection = keyIn.nextInt();
                            System.out.println("Enter the Semester period (Fall, Spring, Summer)");
                            String facultyPeriodSelection = keyIn.next();
                            System.out.println("Enter the Semester year (20XX)");
                            int facultyYearSelection = keyIn.nextInt();
                       
                            printFacultyCourse(facultyEnrollmentArray, facultyEnrollmentCount, courseArray, courseCount,
                            facultySelection, facultyPeriodSelection, facultyYearSelection);
                            break;
                    }


                    break;
                case 5:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("1. Show all courses a student is enrolled in for a semester \n2. Show all students enrolled in a class for a semester");
                    int choice = keyIn.nextInt();
                    switch (choice)
                    {
                        case 1: 
                            System.out.println("Enter Student ID");
                            int studentSelection = keyIn.nextInt();
                            System.out.println("Enter Period (Fall, Spring, Summer):");
                            String periodSelection = keyIn.next();
                            System.out.println("Enter Period Year:");
                            int yearSelection = keyIn.nextInt();
                            
                            showStudentSchedule(studentEnrollmentArray, studentEnrollmentCount, studentSelection, yearSelection, periodSelection, courseArray, courseCount);
                            
                            
                            break;
                        case 2:
                            
                            System.out.println("Please enter Course ID:");
                            int courseSelection = keyIn.nextInt();
                            keyIn.nextLine();
                            
                            System.out.println("Please enter Semester Period (Fall, Spring, Summer):");
                            periodSelection = keyIn.next();
                            
                            System.out.println("Please enter semester year:");
                            yearSelection = keyIn.nextInt();
                            
                            
                            printStudentRoster(studentEnrollmentArray, studentEnrollmentCount, yearSelection, periodSelection, courseSelection, studentCount, studentArray);
                            break;
                    }
                    




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
        in.nextLine();

        System.out.println("Please enter Student Address:");
        String address = in.nextLine();
        

        System.out.println("Please enter Student Email:");
        String email = in.nextLine();
      

        System.out.println("Please enter Student GPA:");
        double GPA = in.nextDouble();
        in.nextLine();

        System.out.println("Please enter Student emergency contact Name:");
        String contactName = in.nextLine();

        System.out.println("Please enter Student emergency contact Phone #:");
        String contactNum = in.nextLine();
    

        System.out.println("Please enter Student emergency contact address:");
        String contactAddress = in.nextLine();
    

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
        in.nextLine();

        System.out.println("Please enter Faculty Name:");
        String emplName = in.nextLine();
        

        System.out.println("Please enter Faculty email:");
        String emplEmail  = in.nextLine();
        

        System.out.println("Please enter Faculty building:");
        String building = in.nextLine();
       

        System.out.println("Please enter Faculty Office Number:");
        int officeNum = in.nextInt();
        in.nextLine();

        System.out.println("Please enter employee phone number:");
        String emplPhone = in.nextLine();

        System.out.println("Please enter Faculty Department:");
        String dept = in.nextLine();

        System.out.println("Please enter Faculty Position:");
        String position = in.nextLine();

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
        
        System.out.println("Please enter course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter course prefix");
        String prefix = in.next();
        
        System.out.println("Please enter course number");
        int courseNum = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter course name");
        String courseName = in.nextLine();
        
        System.out.println("Please enter course days");
        int days = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter course time start");
        String timeStart = in.nextLine();
        
        System.out.println("Please enter course time end");
        String timeEnd = in.nextLine();
        
        System.out.println("Please enter course credit hours");
        int creditHr = in.nextInt();


        Course c1 = new Course(courseID, prefix, courseNum, courseName, days, timeStart, timeEnd, creditHr);     
        courseArray[courseCount] = c1;
                
    }
    
    
        
  
    
    public static void enrollStudent(Enrollment[] studentEnrollmentArray, int studentEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Student ID:");
        int studentID = in.nextInt();
        
        System.out.println("Please enter course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter semester year:");
        int semesterYear = in.nextInt();
        in.nextLine();
        
        System.out.println("Please eneter semester period:");
        String semesterPeriod = in.nextLine();
       

        Enrollment e1 = new Enrollment(studentID, courseID, semesterYear, semesterPeriod);
        studentEnrollmentArray[studentEnrollmentCount] = e1;
    }
    
    public static void enrollFaculty(Enrollment[] facultyEnrollmentArray, int facultyEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();
        
        System.out.println("Please enter course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter semester year:");
        int semesterYear = in.nextInt();
        in.nextLine();
        
        System.out.println("Please eneter semester period:");
        String semesterPeriod = in.nextLine();
        
        
        Enrollment e1 = new Enrollment(facultyID, courseID, semesterYear, semesterPeriod);
        facultyEnrollmentArray[facultyEnrollmentCount] = e1;
    }
    
    
    public static void printSemCourses(Enrollment[] studentEnrollmentArray,Course[] courseArray,
            int courseCounter, int studentEnrollmentCounter, String periodSelection, int yearSelection)
    {
        for (int i = 0; i < studentEnrollmentCounter; i++)
        {
            
            if (periodSelection.equals(studentEnrollmentArray[i].semesterPeriod) && yearSelection == studentEnrollmentArray[i].semesterYear)
            {
                int checkCourseID = studentEnrollmentArray[i].courseID;
                for (int j = 0; j < courseCounter; j++)
                {
                    if (checkCourseID == courseArray[j].courseID)
                    {
                        System.out.println(courseArray[j].courseName);
                    }
                }
                
            }
        }
    }
    
    
    public static void printFacultyCourse(Enrollment[] facultyEnrollmentArray, int facultyEnrollmentCounter, Course[] courseArray, int courseCounter,
            int facultySelection, String periodSelection, int yearSelection)
    {
        
        for (int i = 0; i < facultyEnrollmentCounter; i++)
            if (facultyEnrollmentArray[i].getPersonID() == facultySelection && facultyEnrollmentArray[i].semesterPeriod.equals(periodSelection) 
               && facultyEnrollmentArray[i].semesterYear == yearSelection)
            {
               int checkCourseID = facultyEnrollmentArray[i].courseID;
               for (int j = 0; j < courseCounter; j++)
               {
                   if (checkCourseID == courseArray[j].courseID)
                   {
                       System.out.println(courseArray[j].courseName);
                   }
               }
            }
            
        
    }
    
    public static void showStudentSchedule(Enrollment[] studentEnrollmentArray, int studentEnrollmentCounter, 
            int studentSelection, int yearSelection, String periodSelection, Course[] courseArray, int courseCounter)
    {
        for (int i = 0; i < studentEnrollmentCounter; i++)
        {
            if ( studentSelection == studentEnrollmentArray[i].getPersonID() && yearSelection == studentEnrollmentArray[i].semesterYear
                 && periodSelection.equals(studentEnrollmentArray[i].semesterPeriod) )
            {
                int checkCourseID = studentEnrollmentArray[i].courseID;
                
                for (int j = 0; j < courseCounter; j++)
                {
                    if (checkCourseID == courseArray[j].courseID)
                   {
                       System.out.println(courseArray[j].courseName);
                   }
                    
                }
                
                
                
                
            }
            
        }
    }
    
    public static void printStudentRoster(Enrollment[] studentEnrollmentArray, int studentEnrollmentCounter, int yearSelection, String periodSelection, int courseSelection, int studentCounter, Student[] studentArray)
    {
        for (int i = 0; i < studentEnrollmentCounter; i++)
        {
            if ( courseSelection == studentEnrollmentArray[i].courseID && yearSelection == studentEnrollmentArray[i].semesterYear
                 && periodSelection.equals(studentEnrollmentArray[i].semesterPeriod) )
            {
                int checkStudentID = studentEnrollmentArray[i].getPersonID();
                //take student id compare it to student class and print name
                
                for (int j = 0; j < studentCounter; j++)
                {
                    if (checkStudentID == studentArray[j].getStudentID())
                   {
                       System.out.println(studentArray[j].studentName);
                   }
                
                
            }
           
            
            
            
            
            
        }
    }
    
    }
}

