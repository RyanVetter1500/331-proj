//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for schedule. it includes data fields for info we wish to capture and constructors. It also has getters and setters for studentID and facultyID which we set to private


package project;


public class Schedule {
    
    private int studentID;
    public int courseID;
    private int facultyID;
    
    
    
    
    public Schedule(int studentID, int courseID, int facultyID)
    {
        this.studentID = studentID;
        this.courseID = courseID;
        this.facultyID = facultyID;
    }
    
    
    
    
    
    
    public int getStudentID()
   {
       return this.studentID;
   }
   
   public void setStudentID(int studentID)
   {
       this.studentID = studentID;
   }
   
   
   public void setFacultyID(int facultyID)
    {
        this.facultyID = facultyID;
    }
    
    public int getFacultyID()
    {
        return this.facultyID;
    }
    
}
