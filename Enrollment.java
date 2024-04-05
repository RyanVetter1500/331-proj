//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for Enrollment. it includes data fields for info we wish to capture and constructors. It also has getters and setters for PersonID which we set to private


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
