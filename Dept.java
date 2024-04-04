
package project;


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
