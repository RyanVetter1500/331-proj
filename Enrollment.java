//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024

//this is the CDF for Enrollment. it includes data fields for info we wish to capture and constructors. It also has getters and setters for PersonID which we set to private


package com.mycompany.projpart3;


public class Enrollment {
    
    
    
    
    
    public Student studentInstance;
    public Course courseInstance;
    public Semester semesterInstance;
    
    
    
    
    
    public Enrollment(Student studentInstance, Course courseInstance, Semester semesterInstance)
    {
        this.studentInstance = studentInstance;
        this.courseInstance = courseInstance;
        this.semesterInstance = semesterInstance;
    }
    
    
    
}
