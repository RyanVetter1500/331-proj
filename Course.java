
package project;


public class Course {
    
    public int courseID;
    public String prefix;
    public int courseNum;
    public String courseName;
    public int days;
    public String timeStart;
    public String timeEnd;
    public int creditHr;
    
    
    
    
    public Course(int courseID, String prefix, int courseNum, String courseName, int days, String timeStart, String timeEnd, int creditHr)     
    {
         this.courseID = courseID;
         this.prefix = prefix;
         this.courseNum = courseNum;
         this.courseName = courseName;
         this.days = days;
         this.timeStart = timeStart;
         this.timeEnd = timeEnd;
         this.creditHr = creditHr;   
        
    }
    
}
