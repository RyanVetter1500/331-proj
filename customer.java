
//Ryan Vetter
//3/9/2024
//this is a class definition file for the customer class. 
//it defines data fields for the class as well as constructors, getters, and setters to acomplish tasks for the class




package hw7;




public class customer {
    
    //data fields
    
    private String name;
    private String email;
    private double balance;
    private transaction[] translist = new transaction[100];
    
    //constructors
    
    
    public customer(String name, String email, double balance)
    {
        this.name = name;
        this.email = email;
        this.balance = balance;
        
        
    }    
        
    public customer()
    
    {
        name = "n/a";
        email = "n/a";
        balance = 0.0;
    }
        
    //getters and setters for each variable. getters return value, setters update/ assign value. 

    
    public void setname(String name)
    {
        this.name = name;
    }
               
    public String getname()
    {
        return this.name;
        
    }
    
    public void setemail(String email)
    {
        this.email = email;
    }
    
    public String getemail()
    {
        return this.email;
    }
    
    public void setbalance(double balance)
    {
        this.balance = balance;
    }
    
    public double getbalance()
    {
        return this.balance;
    }
    
    //settranslist takes in a transaction object and a position to put that object into in the list 
    
    public void settranslist(transaction t1, int position)
    {
        
        this.translist[position] = t1;
    }
    
    public transaction[] gettranslist()
    {
        return this.translist;
    }
    
    
    
}
