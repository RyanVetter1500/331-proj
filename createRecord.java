
package com.mycompany.projpart3;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;


public class createRecord {
    
    public App parentWindow;
    
    public createRecord(App parentWindow)
    {
        this.parentWindow = parentWindow;
        
        
        
        
        
        Button createStudent = new Button("Create a student");
        Button createCourse = new Button("Create a course");
        Button createFaculty = new Button("Create a faculty");
        Button createSemester = new Button("Create a semester");
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 300, 400);
        Stage primaryStage = new Stage();
        
        gPane.add(createStudent, 0 , 0);
        gPane.add(createCourse, 1 , 0);
        gPane.add(createFaculty, 0 , 1);
        gPane.add(createSemester, 1 , 1);
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Create a Record");
        primaryStage.show();
        
        createStudent.setOnAction(e -> {
            Label lblName = new Label("Enter student name");
            TextField txtName = new TextField();
            Label lblSSN = new Label("Enter student SSN");
            TextField txtSSN = new TextField();
            Label lblstudentID = new Label("Enter student ID");
            TextField txtStudentID = new TextField();
            Label lblAddress = new Label("Enter student Address");
            TextField txtAddress = new TextField();
            Label lblEmail = new Label("Enter student Email");
            TextField txtEmail = new TextField();
            Label lblGPA = new Label("Enter student GPA");
            TextField txtGPA = new TextField();
            Label lblContacts = new Label("Enter student Contacts");
            TextField txtContacts = new TextField();
            Button btnSubmit = new Button("Submit");
            
            gPane.add(lblName, 0, 4);
            gPane.add(txtName, 1, 4);
            gPane.add(lblSSN, 0, 5);
            gPane.add(txtSSN, 1, 5);
            gPane.add(lblstudentID, 0, 6);
            gPane.add(txtStudentID, 1, 6);
            gPane.add(lblAddress, 0, 7);
            gPane.add(txtAddress, 1, 7);
            gPane.add(lblEmail, 0, 8);
            gPane.add(txtEmail, 1, 8);
            gPane.add(lblGPA, 0, 9);
            gPane.add(txtGPA, 1, 9);
            gPane.add(lblContacts, 0, 10);
            gPane.add(txtContacts, 1, 10);
            gPane.add(btnSubmit, 0, 11);
            
            
            
            // took out contact list from the student class- figure that out later
            //i took it out to make it a little simpler rn - im guessing we will need 3 seperate text fields for each part of contact
            //also need to add newly created student object to the array
            //use arrayList?
            
            btnSubmit.setOnAction((a) -> {
                
                String name = txtName.getText();
                int SSN = Integer.valueOf(txtSSN.getText());
                int studentID = Integer.valueOf(txtStudentID.getText());
                String address = txtAddress.getText();
                String email = txtEmail.getText();
                double gpa = Double.valueOf(txtGPA.getText());
                
              
                
                Student s1 = new Student(name,SSN,studentID, address, email, gpa);
                   
                    
            
            Label output = new Label(s1.studentName);
            gPane.add(output, 0 , 13);

            });
            
            
            
    });
        
        
        
    }
    
}
