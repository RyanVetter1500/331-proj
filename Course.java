
package project;


public class Course {
    
    
    public String prefix;
    public int courseNum;
    public String courseName;
    public int days;
    public String timeStart;
    public String timeEnd;
    public int creditHr;
    
    
    
    
    public Course( String prefix, int courseNum, String courseName, int days, String timeStart, String timeEnd, int creditHr)     
    {
         this.prefix = prefix;
         this.courseNum = courseNum;
         this.courseName = courseName;
         this.days = days;
         this.timeStart = timeStart;
         this.timeEnd = timeEnd;
         this.creditHr = creditHr;   
        
    }
    
}
