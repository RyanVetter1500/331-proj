/*
Ryan Vetter

Dr. Ezell 331 3/9/2024

this is a simulation of a bank account program
users can open and view accounts, make transactions, report fraud, and get an overview of the bank.
it uses two classes - one for customers and one for transactions to keep track of info
loops are used extensivley throughout the program to iterate through lists, namely the applications customer list and each instance object of the customer classes 
own transaction list. 
*/


package hw7;

import java.util.*;
import java.lang.*; 

public class app {
    
    
   
    
    //next time do getters and setters in beginning
    //consider enhanced for loop
    //put some of this in methods?
    
    
    
    public static void main(String[] args) {
        
        String choice = "";
        Scanner in = new Scanner(System.in);
        
        //initializing temporary objects
        customer c1 = new customer();
        transaction t1 = new transaction();
        
        
        int custcount = 0;
        double sumacc = 0.0;
        double tempbalance = 0.0;
        String redacted = "";
        
        //chosen account is the index value of the object(account) we want to witdrawl or deposit to
        int chosenacc = 0;
        
        customer[] customerList = new customer[100];
        
    
     while (!choice.equals("0"))
     {
        System.out.println("\n---------menu-------------");
        System.out.println("1. create an account\n2. make a transaction\n3. print transactions for a customer\n4. Print summary of bank\n5. Report fraud\n0. Exit");
        
        choice = in.next();
        
       
     
        if (choice.equals("1"))
        {
                    
            System.out.println("Enter customers name: ");
            String fname = in.next();
            String lname = in.next();
            
            //had to do 2 next statements- having tons of trouble with .nextLine not reading name correctly
            String name = fname + " " + lname;
            
            System.out.println("Enter customers email: ");
            String email = in.next();
            
            System.out.println("Enter customers beginning balance: ");
            double begBal = in.nextDouble();
            //gets leftover \n
            in.nextLine();

            
            c1 = new customer(name, email, begBal);
            customerList[custcount] = c1;
            custcount++;
            System.out.println("Customer added!");
            
        }
        
        
        if (choice.equals("2"))
        {
            //prints list of customers to choose from//
            for (int i = 0; i < custcount; i++)
            {
                if (customerList[i] == null)
                {
                    break;
                }
                
                System.out.println(customerList[i].getname());
                
            }
            
            //takes in input so that user can choose an account
            System.out.println("please pick an account");
            
            String fname = in.next();
            String lname = in.next();
            String chosen = fname + " " + lname;
           
            for (int i = 0; i < customerList.length; i++)
            {
                
                //several of these exist throughout program. they are to make sure that if a element is null, it does not throw an error
                if (customerList[i] == null)
                    {
                        break;
                    }
                
                
                if (chosen.equals(customerList[i].getname()))
                    {
                        chosenacc = i;
                    }
                
            }
            
            System.out.println("Would you like to make a deposit or withdrawal (d for deposit, w for withdrawl)");
            String type = in.next();
            System.out.println("please enter a description");
            String descript = in.next();
            System.out.println("Please enter an amount");
            double amount = in.nextDouble();
            switch (type)
                    {
                
                case "w":
                   
                    t1 = new transaction(amount, type, descript);
                     
                    //assign balance of chosen account to temp balance then subtract amount from temp balance.
                    //temp balance is then set to the balance for the chosen account using the setbalance setter method
                    tempbalance = customerList[chosenacc].getbalance(); 
                    tempbalance -= t1.getamount();
                    customerList[chosenacc].setbalance(tempbalance);
                    
                    //this method iterates through the chosen accounts transaction list. if a null value is encountered aka you have passed 
                    //all the previous transactions, the transaction is added to the transaction list at that particular index value
                    for (int i = 0; i < customerList[chosenacc].gettranslist().length; i++)
                        {
                        if (customerList[chosenacc].gettranslist()[i] == null)
                            {
                            customerList[chosenacc].settranslist(t1, i);
                            break;
                            }
                        
                        }
      
                  
                  System.out.printf("Your balance is now $%,.2f", customerList[chosenacc].getbalance());
                  break;
                     
                case "d":
                    t1 = new transaction(amount, type, descript);
                     
                    tempbalance = customerList[chosenacc].getbalance(); 
                    tempbalance += t1.getamount();
                    customerList[chosenacc].setbalance(tempbalance);
                     
                 
                     
                    for (int i = 0; i < customerList[chosenacc].gettranslist().length; i++)
                        {
                        if (customerList[chosenacc].gettranslist()[i] == null)
                            {
                            customerList[chosenacc].settranslist(t1, i);
                            break;
                            }
                       
                        }
                     
                    
                     System.out.printf("Your balance is now $%,.2f", customerList[chosenacc].getbalance());
                     break;
                    
                    
                    }
                    
            
        }
        
        if (choice.equals("3"))
        {
            //prints accounts
            for (int i = 0; i < custcount; i++)
            {
                System.out.println(customerList[i].getname());
                
            }
            
            System.out.println("please pick an account");
            String fname = in.next();
            String lname = in.next();
            String chosen = fname + " " + lname;
            
            //loop checks if the inputed name matches a name in the customer list
            for (int i = 0; i < customerList.length; i++)
            {
                if (customerList[i] == null)
                {
                    break;
                }
                
                if (chosen.equals(customerList[i].getname()))
                {
                chosenacc = i;
                break;
                }
                
            }
              
             //prints description and amount for transactions on a specific account
             for (int i = 0; i < customerList[chosenacc].gettranslist().length; i++)
             {
                 
                 if (customerList[chosenacc].gettranslist()[i] == null)
                 {
                     break;
                 }
                 System.out.printf("%-5s %-15s $%,.2f\n",customerList[chosenacc].gettranslist()[i].gettype(),
                         customerList[chosenacc].gettranslist()[i].getdescript(), customerList[chosenacc].gettranslist()[i].getamount());
                 
                
             }
                
               
            System.out.printf("\nYour balance is: $%,.2f", customerList[chosenacc].getbalance());
            
        }
       
        if (choice.equals("4"))
        {
            //prints through customer list 
            for (int i = 0; i < customerList.length; i++)
            {
                if (customerList[i] == null)
                 {
                     break;
                 }
                
                //this loop iterates through each name and after the first 3 characters, replaces whatever is there with asterisks
                for (int j = 0; j < customerList[i].getname().length(); j++ )
                {
                    
                    if (customerList[i] == null)
                    {
                        break;
                    }

                    
                    else if (j < 3)
                    {
                        redacted += customerList[i].getname().charAt(j);
                    }
                    else
                    {
                        redacted += "*";
                    }
                }
                
                
                System.out.printf("%-20s $%,.2f\n", redacted, customerList[i].getbalance());
                redacted = "";
            }
            
            //loop sums account balances
            for (int i = 0; i < customerList.length; i++)
            {
                 if (customerList[i] == null)
                 {
                     break;
                 }
                 
                 sumacc += customerList[i].getbalance();
            }
            
            System.out.printf("\nTotal balance across all accounts: $%,.2f\n", sumacc);
            //had to reset sumacc at end so that if its chosen again by user it wont double count 
            sumacc = 0;
        }
        
        if (choice.equals("5"))
        {
            for (int i = 0; i < custcount; i++)
            {
                System.out.println(customerList[i].getname());
                
            }
            
            System.out.println("please select an account: ");
            String fname = in.next();
            String lname = in.next();
            String chosen = fname + " " + lname;
            
            //checks if input is equal to a name, if it is assigns index position of name in list to chosenacc
            for (int i = 0; i < customerList.length; i++)
            {
                if (customerList[i] == null)
                {
                    break;
                }
                
                if (chosen.equals(customerList[i].getname()))
                {
                    chosenacc = i;
                    break;
                }
            }
            
            //iterates through specific customers transactions, prints them if they are a withdrawl
            for (int i = 0; i < customerList[chosenacc].gettranslist().length; i++)
             {
                 
                 if (customerList[chosenacc].gettranslist()[i] == null)
                 {
                    break;
                 }
                 
                 if (customerList[chosenacc].gettranslist()[i].gettype().equals("w"))
                    {
                    System.out.printf("%-15s $%,.2f\n", customerList[chosenacc].gettranslist()[i].getdescript(), customerList[chosenacc].gettranslist()[i].getamount());
                    }
                  
             }
           
            //loop takes in input and checks that it is valid and is a withdrawl. if these conditions are satisfied, a temporary credit is issued and the customers
            //bank account is updated.
            System.out.println("Please select a transaction to dispute (enter in description): ");
            String dispute = in.next();
            for (int i = 0; i < customerList[chosenacc].gettranslist().length; i++)
            {
                if (customerList[chosenacc].gettranslist()[i] == null)
                 {
                    break;
                 }
                
               if (customerList[chosenacc].gettranslist()[i].getdescript().equals(dispute) & customerList[chosenacc].gettranslist()[i].gettype().equals("w"))
               {
                   tempbalance = customerList[chosenacc].getbalance();
                   tempbalance  += customerList[chosenacc].gettranslist()[i].getamount();
                   customerList[chosenacc].setbalance(tempbalance);

                      
               }
                
            }
            System.out.println("Thank you for reporting a claim. A representative will reach out to you in 2-3 business days. A temporary credit has been issued");
            System.out.printf("Balance is now: $%,.2f", customerList[chosenacc].getbalance());
            
            
        }
        
        
        
     }    
     System.exit(0);
     
     
     
   
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
