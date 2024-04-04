
package project;


public class Enrollment {
    
    
    private int personID;
    public int courseID;
    public int semesterYear;
    public String semesterPeriod;
    
    
    
    public Enrollment(int personID, int courseID, int semesterYear, String semesterPeriod)
    {
       this.personID = personID;
       this.courseID = courseID;
       this.semesterYear = semesterYear;
       this.semesterPeriod = semesterPeriod;
    }
    
    public int getPersonID()
    {
        return this.personID;
    }
    
    public void setPersonID(int personID)
    {
        this.personID = personID;
    }
    
}
