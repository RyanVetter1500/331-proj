//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for schedule. it includes data fields for info we wish to capture and constructors. It also has getters and setters for studentID and facultyID which we set to private


package com.mycompany.projpart3;


public class Schedule {
    
    
    
    public Faculty facultyInstance;
    public Course courseInstance;
    public Semester semesterInstance;
    
    
    
    
    public Schedule(Faculty facultyInstance, Course courseInstance, Semester semesterInstance)
    {
        
        
        this.facultyInstance = facultyInstance;
        this.courseInstance  = courseInstance;
        this.semesterInstance = semesterInstance;
        
    }
    
    
    
    
    
    
    
}
