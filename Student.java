//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for student. it includes data fields for info we wish to capture and constructors. It also has getters and setters for SSN, StudentID, and GPA which we set to private


package project;


public class Student {
    
    
    
    public String studentName;
    private int ssn;
    private int studentID;
    public String address;
    public String email;
    private double gpa;
    public String[] contacts;
    
    public Student( String studentName, int ssn, int studentID, String address, String email, double gpa, String[] contacts)
    {
         this.studentName = studentName;
         this.ssn = ssn;
         this.studentID = studentID;
         this.address = address;
         this.email = email;
         this.gpa = gpa;
         this.contacts = contacts;
        
    }
    
   public int getSSN()
   {
       return this.ssn;
   }
   
   public void setSSN(int ssn)
   {
       this.ssn = ssn;
   }
   
   public int getStudentID()
   {
       return this.studentID;
   }
   
   public void setStudentID(int studentID)
   {
       this.studentID = studentID;
   }
   
   public double getGPA()
   {
       return this.gpa;
   }
   
   public void setgpa(double gpa)
   {
       this.gpa = gpa;
   }
    
    
}
