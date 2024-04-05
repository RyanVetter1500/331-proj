//Akhil Reddy, Ryan Vetter, Bilal Asif - 4/1/2024
//this is the CDF for semester. it includes data fields for info we wish to capture and constructors. 


package project;


public class Semester {
    
    public String period;
    public int year;
    
    
    //took out course number becuz of ezells sugestion, orginally had coursenumber in here
    
    
    public Semester(String period, int year)
     {
         
         this.period = period;
         this.year = year;
         
    }
    
}
