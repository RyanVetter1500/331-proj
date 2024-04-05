//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for faculty. it includes data fields for info we wish to capture and constructors. It also has getters and setters for facultyID which we set to private

package project;


public class Faculty {
    
    private int facultyID;
    public String emplName;
    public String emplEmail;
    public String building;
    public int officeNum;
    public String emplPhone;
    public String dept;
    public String position;
    
    
    
    
   public Faculty( int facultyID, String emplName, String emplEmail, String building, int officeNum, String emplPhone, String dept, String position)
   {
        this.facultyID = facultyID;
        this.emplName = emplName;
        this.emplEmail = emplEmail;
        this.building = building;
        this.officeNum = officeNum;
        this.emplPhone = emplPhone;
        this.dept = dept;
        this.position = position;
   
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
