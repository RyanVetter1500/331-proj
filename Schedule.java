
package project;


public class Schedule {
    
    private int studentID;
    public int courseNum;
    private int facultyID;
    
    
    
    
    public Schedule(int studentID, int courseNum, int facultyID)
    {
        this.studentID = studentID;
        this.courseNum = courseNum;
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
