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

public class SystemManagementAppFINAL {

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        int x = 2; //control variable for while loop
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
        //initialize arrays and counters
        while (x > 1)
        {
            System.out.println("Please choose an option from the following by typing in the corresponding number:");
            System.out.println("1 - Create or Edit a Student, Faculty, Course, or Semester");
            System.out.println("2 - Assign a Faculty Member to a Course");
            System.out.println("3 - Enroll a Student in a Course");
            System.out.println("4 - Print Semester Report");
            System.out.println("5 - Show Student-Course Info");
            System.out.println("6 - Exit Application");
            System.out.println("Enter Selection:");
            int selection = keyIn.nextInt();
            switch (selection) {
                
                //case 1 prompts the user for which type of record they want to create and calls the respective method to do so
                case 1:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("Create: \n1. Student \n2. Faculty \n3. Course \n4. Semester \n5. Edit Record");
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
                        case 5:
                            editRecord(studentArray, studentCount, facultyArray, facultyCount, courseArray, courseCount, semesterArray, semesterCount);
                            break;
                        
                        default: System.out.println("Please enter a valid selection");
                        break;
                    }



                    break;
                    
                //case 2 calls the enroll faculty method to assign a faculty member to a course
                case 2:
                    enrollFaculty(facultyEnrollmentArray, facultyEnrollmentCount);
                    facultyEnrollmentCount++;
                    break;




                //case 3 calls the enroll student method to enroll a student in a course    
                case 3:
                    enrollStudent(studentEnrollmentArray, studentEnrollmentCount);
                    studentEnrollmentCount++;

                    break;
                    
                //case 4 prints reports on courses taught
                case 4:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("1 - Print all Courses taught in a Semester");
                    System.out.println("2 - Print all Courses taught by a Faculty member");
                    int printSelection = keyIn.nextInt();
                    switch (printSelection) {
                        //this part takes in info and calls the print semester courses method to print all courses taught in a semester
                        case 1:
                            System.out.println("Enter the Semester period (Fall, Winter, Spring, Summer)");
                            String periodSelection = keyIn.next();
                            System.out.println("Enter the Semester year (20XX)");
                            int yearSelection = keyIn.nextInt();
                            
                            printSemCourses(studentEnrollmentArray, courseArray, courseCount, studentEnrollmentCount, periodSelection, yearSelection);
                            break;
                        
                        //this part takes in info and calls the print faculty courses method to print all courses a faculty is teaching for a semester
                        case 2:
                            System.out.println("Enter Faculty ID");
                            int facultySelection = keyIn.nextInt();
                            System.out.println("Enter the Semester period (Fall, Winter, Spring, Summer)");
                            String facultyPeriodSelection = keyIn.next();
                            System.out.println("Enter the Semester year (20XX)");
                            int facultyYearSelection = keyIn.nextInt();
                       
                            printFacultyCourse(facultyEnrollmentArray, facultyEnrollmentCount, courseArray, courseCount,
                            facultySelection, facultyPeriodSelection, facultyYearSelection);
                            break;
                    }


                    break;
                //prints reports on students
                case 5:
                    System.out.println("Please choose an option from the following by typing in the corresponding number:");
                    System.out.println("1. Show all courses a student is enrolled in for a semester \n2. Show all students enrolled in a class for a semester");
                    int choice = keyIn.nextInt();
                    switch (choice)
                    {
                        case 1: 
                            //shows all courses student is enrolled in for a semester 
                            System.out.println("Enter Student ID");
                            int studentSelection = keyIn.nextInt();
                            System.out.println("Enter Period (Fall, Winter, Spring, Summer):");
                            String periodSelection = keyIn.next();
                            System.out.println("Enter Period Year:");
                            int yearSelection = keyIn.nextInt();
                            
                            showStudentSchedule(studentEnrollmentArray, studentEnrollmentCount, studentSelection, yearSelection, periodSelection, courseArray, courseCount);
                            
                            
                            break;
                        case 2:
                            //shows all students enrolled in a particualr class
                            System.out.println("Please enter Course ID:");
                            int courseSelection = keyIn.nextInt();
                            keyIn.nextLine();
                            
                            System.out.println("Please enter Semester Period (Fall, Winter, Spring, Summer):");
                            periodSelection = keyIn.next();
                            
                            System.out.println("Please enter semester year (20XX):");
                            yearSelection = keyIn.nextInt();
                            
                            
                            printStudentRoster(studentEnrollmentArray, studentEnrollmentCount, yearSelection, periodSelection, courseSelection, studentCount, studentArray);
                            break;
                    }

                    break;

                case 6:
                    //if user wants to end program
                    x = 0;
                    break;
                default:
                    System.out.println("Please Enter a Valid Selection");
                    //if user does not select a valid option

            }
        }

    }
    
    //this method creates a student instance object by taking in input. It puts the instance into a student array at the next avaiible position
    public static void createStudent(Student[] studentArray, int studentCount)
    {
        Scanner in = new Scanner(System.in);
        //student has user enter in all data fields and creates class for student 
        System.out.println("Please enter Student Name:");
        String name = in.nextLine();

        System.out.println("Please enter Student SSN (Don't separate with any characters):");
        int ssn = in.nextInt();

        System.out.println("Please enter Student Student ID:");
        int studentID = in.nextInt();
        in.nextLine();

        System.out.println("Please enter Student address:");
        String address = in.nextLine();
        

        System.out.println("Please enter Student email:");
        String email = in.nextLine();
      

        System.out.println("Please enter Student GPA:");
        double GPA = in.nextDouble();
        in.nextLine();

        System.out.println("Please enter Student emergency contact name:");
        String contactName = in.nextLine();

        System.out.println("Please enter Student emergency contact phone #:");
        String contactNum = in.nextLine();
    

        System.out.println("Please enter Student emergency contact address:");
        String contactAddress = in.nextLine();
    

        String[] contactList = {contactName, contactNum, contactAddress};

        Student s1 = new Student(name, ssn, studentID, address, email, GPA, contactList);
        studentArray[studentCount] = s1;
        System.out.println("-----New Student Created-----");
    }
    
    //this method creates a faculty instance object by taking in input. It puts the instance into a faculty array at the next avaiible position
    public static void createFaculty(Faculty[] facultyArray, int facultyCount)
    {
        Scanner in = new Scanner(System.in);
        //faculty has user enter in all data fields and creates class for faculty 
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();
        in.nextLine();

        System.out.println("Please enter Faculty name:");
        String emplName = in.nextLine();
        

        System.out.println("Please enter Faculty email:");
        String emplEmail  = in.nextLine();
        

        System.out.println("Please enter Faculty building:");
        String building = in.nextLine();
       

        System.out.println("Please enter Faculty office number:");
        int officeNum = in.nextInt();
        in.nextLine();

        System.out.println("Please enter employee phone number:");
        String emplPhone = in.nextLine();

        System.out.println("Please enter Faculty department:");
        String dept = in.nextLine();

        System.out.println("Please enter Faculty position:");
        String position = in.nextLine();

        Faculty f1 = new Faculty(facultyID, emplName, emplEmail, building, officeNum, emplPhone, dept, position); 
        facultyArray[facultyCount] = f1;
        System.out.println("-----New Faculty Created-----");
    }
    
    //this method creates a semester instance object by taking in input. It puts the instance into a semester array at the next avaiible position
    public static void createSemester(Semester[] semesterArray, int semesterCount)
    {
        //semester has user enter in all data fields and creates class for semester     
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter Semester year (20XX):");
        int year = in.nextInt();
        in.nextLine();

        System.out.println("Please enter Semester period (Fall, Winter, Spring, Summer):");
        String period = in.nextLine();
        
        Semester semester1 = new Semester(period, year);
        semesterArray[semesterCount] = semester1;
        System.out.println("-----New Semester Created-----");
        
    }
    
    //this method creates a course instance object by taking in input. It puts the instance into a course array at the next avaiible position
    public static void createCourse(Course[] courseArray, int courseCount)
    {
        Scanner in = new Scanner(System.in);
        //course has user enter in all data fields and creates class for course  
        
        System.out.println("Please enter Course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter Course prefix (ex. CIS):");
        String prefix = in.next();
        
        System.out.println("Please enter Course number (ex. 331):");
        int courseNum = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter Course name (ex. Intro to Programming):");
        String courseName = in.nextLine();
        
        System.out.println("Please enter number of days per week that the course meets:");
        int days = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter Course start time:");
        String timeStart = in.nextLine();
        
        System.out.println("Please enter Course end time:");
        String timeEnd = in.nextLine();
        
        System.out.println("Please enter Course credit hours:");
        int creditHr = in.nextInt();


        Course c1 = new Course(courseID, prefix, courseNum, courseName, days, timeStart, timeEnd, creditHr);     
        courseArray[courseCount] = c1;
        System.out.println("-----New Course Created-----");
                
    }
       
  
    //this method enrolls a student into a particular course for a semester. It does this by creating an instance object of the enrollment class and puts that object in a student enrollment array
    public static void enrollStudent(Enrollment[] studentEnrollmentArray, int studentEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Student ID:");
        int studentID = in.nextInt();
        
        System.out.println("Please enter Course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter Semester year (20XX):");
        int semesterYear = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter Semester period (Fall, Winter, Spring, Summer):");
        String semesterPeriod = in.nextLine();
       

        Enrollment e1 = new Enrollment(studentID, courseID, semesterYear, semesterPeriod);
        studentEnrollmentArray[studentEnrollmentCount] = e1;
        System.out.println("-----Student Now Enrolled-----");
    }
    
    //this method enrolls a faculty into a particular course for a semester. It does this by creating an instance object of the enrollment class and puts that object in a faculty enrollment array
    public static void enrollFaculty(Enrollment[] facultyEnrollmentArray, int facultyEnrollmentCount)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Faculty ID:");
        int facultyID = in.nextInt();
        
        System.out.println("Please enter Course ID:");
        int courseID = in.nextInt();
        
        System.out.println("Please enter Semester year (20XX):");
        int semesterYear = in.nextInt();
        in.nextLine();
        
        System.out.println("Please enter Semester period (Fall, Winter, Spring, Summer):");
        String semesterPeriod = in.nextLine();
        
        
        Enrollment e1 = new Enrollment(facultyID, courseID, semesterYear, semesterPeriod);
        facultyEnrollmentArray[facultyEnrollmentCount] = e1;
        System.out.println("-----Faculty Now Enrolled-----");
    }
    
    
    //this method takes a year and period (semester) and 
    //iterates through the student enrollment array looking for matches on period and year. If it finds one it prints the name of the course 
    //AKA it prints all courses for a semester
    public static void printSemCourses(Enrollment[] studentEnrollmentArray,Course[] courseArray,
            int courseCounter, int studentEnrollmentCounter, String periodSelection, int yearSelection)
    {
        System.out.println("----------");
        
        for (int i = 0; i < studentEnrollmentCounter; i++)
        {
            
            if (periodSelection.equals(studentEnrollmentArray[i].semesterPeriod) && yearSelection == studentEnrollmentArray[i].semesterYear)
            {
                int checkCourseID = studentEnrollmentArray[i].courseID;
                for (int j = 0; j < courseCounter; j++)
                {
                    if (checkCourseID == courseArray[j].courseID)
                    {
                        System.out.println(courseArray[j].prefix + " " + courseArray[j].courseNum + ": " + courseArray[j].courseName + "\n\tDays per Week: " + courseArray[j].days + "\n\tStart Time: " +
                        courseArray[j].timeStart + "\n\tEnd Time: " + courseArray[j].timeEnd + "\n\tCredits: " + courseArray[j].creditHr);
                    }
                }
                
            }
        }
        System.out.println("-----End of Semester Class List-----");
    }
    
    
    //this method takes a faculty ID, year and period and iterates through the faculty enrollment array looking for matches for all three conditions
    //if it finds one it prints the course name
    //aka it prints all courses a proffessor is teaching for a semester
    
    public static void printFacultyCourse(Enrollment[] facultyEnrollmentArray, int facultyEnrollmentCounter, Course[] courseArray, int courseCounter,
            int facultySelection, String periodSelection, int yearSelection)
    {
        System.out.println("----------");
        
        for (int i = 0; i < facultyEnrollmentCounter; i++)
        {
            if (facultyEnrollmentArray[i].getPersonID() == facultySelection && facultyEnrollmentArray[i].semesterPeriod.equals(periodSelection) 
               && facultyEnrollmentArray[i].semesterYear == yearSelection)
            {
               int checkCourseID = facultyEnrollmentArray[i].courseID;
               for (int j = 0; j < courseCounter; j++)
               {
                   if (checkCourseID == courseArray[j].courseID)
                   {
                        System.out.println(courseArray[j].prefix + " " + courseArray[j].courseNum + ": " + courseArray[j].courseName + "\n\tDays per Week: " + courseArray[j].days + "\n\tStart Time: " +
                        courseArray[j].timeStart + "\n\tEnd Time: " + courseArray[j].timeEnd + "\n\tCredits: " + courseArray[j].creditHr);
                   }
               }
            }
            
        }
        
        System.out.println("-----End of Faculty Schedule-----");
    }
    
    //this method takes in student ID, year and period and iterates through the student enrollment array to find matches. if it finds one it saves the courseID and prints the name of the course
    //aka it prints a students schedule for a particlar semester
    
    
    public static void showStudentSchedule(Enrollment[] studentEnrollmentArray, int studentEnrollmentCounter, 
            int studentSelection, int yearSelection, String periodSelection, Course[] courseArray, int courseCounter)
    {
        System.out.println("----------");
        
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
                        System.out.println(courseArray[j].prefix + " " + courseArray[j].courseNum + ": " + courseArray[j].courseName + "\n\tDays per Week: " + courseArray[j].days + "\n\tStart Time: " +
                        courseArray[j].timeStart + "\n\tEnd Time: " + courseArray[j].timeEnd + "\n\tCredits: " + courseArray[j].creditHr);
                   }
                    
                }
  
            }
            
        }
        
        System.out.println("-----End of Student Schedule-----");
    }
    
    //this method takes in a course ID, year, and period and iterates through the student enrollment array to find matches. if it does it notes the student ID and then prints the name of the particular student
    //aka it prints a class roster for a particualr course for a semester 
    
    public static void printStudentRoster(Enrollment[] studentEnrollmentArray, int studentEnrollmentCounter, int yearSelection, String periodSelection, int courseSelection, int studentCounter, Student[] studentArray)
    {
        System.out.println("----------");
        
        for (int i = 0; i < studentEnrollmentCounter; i++)
        {
            if ( courseSelection == studentEnrollmentArray[i].courseID && yearSelection == studentEnrollmentArray[i].semesterYear
                 && periodSelection.equals(studentEnrollmentArray[i].semesterPeriod) )
            {
                int checkStudentID = studentEnrollmentArray[i].getPersonID();
                //take student id compare it to student class and print name, email
                
                for (int j = 0; j < studentCounter; j++)
                {
                    if (checkStudentID == studentArray[j].getStudentID())
                   {
                       System.out.println(studentArray[j].studentName + " " + studentArray[j].email);
                   }
                
                
            }

            
        }
    }
        System.out.println("-----End of Course Roster-----");
    }
    
    
    //this method allows the user to edit previosly made records
    
    public static void editRecord(Student[] studentArray, int studentCount, Faculty[] facultyArray,
            int facultyCount, Course[] courseArray, int courseCount, Semester[] semesterArray, int semesterCount)
    {
        
        int selectedStudentPosition = 0;
        int selectedFacultyPosition = 0;
        int selectedCoursePosition = 0;
        int selectedSemPosition = 0;
        
        Scanner in = new Scanner(System.in);
        
        //user chooses which type of record they want to edit. Switch statement has different cases based on which option they pick
        
        System.out.println("What record would you like to edit?");
        System.out.println("1. Student \n2. Faculty \n3. Course \n4. Semester");
        int selection = in.nextInt();
        
        switch (selection)
        {
            
            //case 1 handles changing a students info. program prompts user for which data field they want to change and makes the necessary changes
            
            case 1:
            System.out.println("What student would you like to edit? (enter Student ID):");
            int studentSelection = in.nextInt();
            in.nextLine();
            
            System.out.println("What data would like to edit?");
            System.out.println("Name, SSN, Address, Email, GPA, Contacts (Enter one option):");
            String dataSelection = in.nextLine();
            
           
            System.out.println("What is the new value?:");
            String newVal = in.next();
            
            for (int i = 0; i < studentCount; i++)
            {
                if (studentSelection == studentArray[i].getStudentID())
                {
                    selectedStudentPosition = i;
                    System.out.println();
                }
            }
            
            switch (dataSelection)
            {
                case "Name":
                    studentArray[selectedStudentPosition].studentName = newVal;
                    break;
                    
                case "SSN":
                    int selectedSSN = Integer.valueOf(newVal);
                    studentArray[selectedStudentPosition].setSSN(selectedSSN);
                    break;
                    
                case "Address":
                    studentArray[selectedStudentPosition].address = newVal;
                    break;
                    
                case "Email":
                    studentArray[selectedStudentPosition].email = newVal;
                    break;
                    
                case "GPA":
                    double selectedGPA = Double.valueOf(newVal);
                    studentArray[selectedStudentPosition].setgpa(selectedGPA);
                    
                    break;
                
                case "Contacts":
                    
                    System.out.println("Do you want to edit emergency contact name, phone number or address? (Enter one: 'Name', 'Phone Number', 'Address')");
                    String selectedOption = in.nextLine();
                    
                    System.out.println("Enter in new value:");
                    String newValue = in.nextLine();
                    
                    switch (selectedOption)
                    {
                        case "Name":
                            studentArray[selectedStudentPosition].contacts[0] = newValue;
                            break;
                        case "Phone Number":
                            studentArray[selectedStudentPosition].contacts[1] = newValue;
                            break;
                        case "Address":
                            studentArray[selectedStudentPosition].contacts[2] = newValue;
                            break;
                    }

                    
                    break;
                    
            }

            break;
            
           //case 2 handles changing a faculty members info. program prompts user for which data field they want to change and makes the necessary changes

            
            case 2:
            
            System.out.println("What faculty would you like to edit? (Enter Faculty ID):");
            int facultySelection = in.nextInt();
            in.nextLine();
            
            System.out.println("What data would like to edit?");
            System.out.println("Name, Email, Building, Office Number, Phone, Dept, Position (enter one option)");
            String facDataSelection = in.nextLine();
            
           
            System.out.println("What is the new value?");
            String facNewVal = in.next();
            
            
            for (int i = 0; i < studentCount; i++)
            {
                if (facultySelection == facultyArray[i].getFacultyID())
                {
                    selectedFacultyPosition = i;
                    
                }
            }
            
            switch (facDataSelection)
                {
                
                
                case "Name":
                    facultyArray[selectedFacultyPosition].emplName = facNewVal;
                    break;
                
                case "Email":
                    facultyArray[selectedFacultyPosition].emplEmail = facNewVal;
                    break;
                
                case "Building":
                    facultyArray[selectedFacultyPosition].building = facNewVal;
                    break;
                
                case "Office Number":
                    int selectedOfficeNum = Integer.valueOf(facNewVal);
                    facultyArray[selectedFacultyPosition].officeNum = selectedOfficeNum;
                    break;
                
                case "Phone":
                    facultyArray[selectedFacultyPosition].emplPhone = facNewVal;
                    break;
                
                case "Dept":
                    facultyArray[selectedFacultyPosition].dept = facNewVal;
                    break;
                
                case "Position":
                    facultyArray[selectedFacultyPosition].position = facNewVal;
                    break;
                
                        
                }
             
            
            break;
            
            //case 3 handles changing a courses  info. program prompts user for which data field they want to change and makes the necessary changes
            case 3:
                
                
                System.out.println("What course would you like to edit? (Enter Course ID)");
                int courseSelection = in.nextInt();
                in.nextLine();
            
                System.out.println("What data would like to edit?");
                System.out.println("Course ID, Prefix, Course Number, Course Name, Days, Start time, End time, Credits (enter one option)");
                String courseDataSelection = in.nextLine();


                System.out.println("What is the new value?");
                String courseNewVal = in.next();


                for (int i = 0; i < courseCount; i++)
                {
                    if (courseSelection == courseArray[i].courseID)
                    {
                        selectedCoursePosition = i;
                        
                    }
                }
                
                switch (courseDataSelection)
                {
                    case "Course ID":
                    int selectedCourseID = Integer.valueOf(courseNewVal);
                    courseArray[selectedCourseID].courseID = selectedCourseID;
                    break;

                    case "Prefix":
                    courseArray[selectedCoursePosition].prefix = courseNewVal;
                        break;
                        
                    case "Course Number":
                        int selectedCourseNum = Integer.valueOf(courseNewVal);
                        courseArray[selectedCoursePosition].courseNum = selectedCourseNum;
                        break;
                        
                    case "Course Name":
                        courseArray[selectedCoursePosition].courseName = courseNewVal;
                        break;
                        
                    case "Days":
                        int selectedDays = Integer.valueOf(courseNewVal);
                        courseArray[selectedCoursePosition].days = selectedDays;
                        break;
                        
                    case "Start Time":
                        courseArray[selectedCoursePosition].timeStart = courseNewVal;
                        break;
                        
                    case "End Time":
                        courseArray[selectedCoursePosition].timeEnd = courseNewVal;
                        break;
                        
                    case "Credits":
                        int selectedCreditHr = Integer.valueOf(courseNewVal);
                        courseArray[selectedCoursePosition].creditHr = selectedCreditHr;
                        break;
                }

                
                
            
            break;
            
            //case 2 handles changing a semesters info. program prompts user for which data field they want to change and makes the necessary changes
            
            case 4:
                System.out.println("Enter Semester year (20XX):");
                int selectedYear = in.nextInt();
                in.nextLine();
                
                System.out.println("Enter Semester period (Fall, Winter, Spring, Summer):");
                String selectedPeriod = in.nextLine();
                
                System.out.println("What would you like to edit? (type either 'period' or 'year')");
                String options = in.nextLine();
                
                System.out.println("What is the new value?");
                String semNewVal = in.nextLine();
                
                
                for (int i = 0; i < semesterCount; i++)
                {
                    if (selectedPeriod.equals(semesterArray[i].period) && selectedYear == semesterArray[i].year)
                    {
                        selectedSemPosition = i;
                    }
                }
                
                switch (options)
                {
                    case "period":
                        semesterArray[selectedSemPosition].period = semNewVal;
                        break;
                        
                    case "year":
                        int selectedSemYear = Integer.valueOf(semNewVal);
                        semesterArray[selectedSemPosition].year = selectedSemYear;
                       break;
                    
                }

            break;
            default: System.out.println("Please enter a valid selection");
            
        }
            
        
        
    }
    
    
    
}

