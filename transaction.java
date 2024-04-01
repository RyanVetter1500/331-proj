
//Ryan Vetter
//3/9/2024
//this is a class definition file for the transaction class. 
//it defines data fields for the class as well as constructors, getters, and setters to acomplish tasks for the class



package hw7;



public class transaction {
    
    //data fields 
    private double amount;
    private String type;
    private String descript;
    
    //note to self- constructors need to be same name as class
    //consturctors below
  public transaction(double amount, String type, String descript)
{
    this.amount = amount;
    this.type = type;
    this.descript = descript;

}
  
  public transaction()
  {
      amount = 0.0;
      type = "n/a";
      descript = "n/a";
  }
  
  //getters and setters for each variable. getters return value, setters update/ assign value. 
  
  public void setamount(double amount)
  {
      this.amount = amount;
  }
  
  public double getamount()
  {
      return this.amount;
  }
  
  public void settype(String type)
  {
      this.type = type;
  }
  
  public String gettype()
  {
      return this.type;
  }
  
  public void setdescript(String descript)
  {
      this.descript = descript;
  }
  
  public String getdescript()
  {
      return this.descript;
  }
    
    
}

