
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
