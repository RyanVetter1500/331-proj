//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for Department. it includes data fields for info we wish to capture and constructors. It also has getters and setters for facultyID which we set to private


package com.mycompany.projpart3;


public class Dept {
    
    private int facultyID;
    public String deptName;
    public int emplCount;
    public String concentrations;
    public String building;
    public String admin;
    
    
    
    public Dept(  int facultyID, String deptName, int emplCount, String concentrations, String building, String admin)
    {
      this.facultyID = facultyID;
      this.deptName = deptName;
      this.emplCount = emplCount;
      this.concentrations = concentrations;
      this.building = building;
      this.admin = admin;
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
