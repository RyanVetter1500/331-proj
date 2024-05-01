/*
Bilal Asif, Ryan Vetter, Akhil Reddy
4/28/2024
this is the file that allows a user to create a record


*/
package com.mycompany.projpart3;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.scene.control.Alert.AlertType;



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
        Scene mainScene = new Scene(gPane, 450, 400);
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
            Label lblContactName = new Label("Enter student contact name");
            TextField txtContactName = new TextField();
            Label lblContactPhone = new Label("Enter student contact phone #");
            TextField txtContactPhone = new TextField();
            Label lblContactAddress = new Label("Enter student contact address");
            TextField txtContactAddress = new TextField();
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
            gPane.add(lblContactName, 0, 10);
            gPane.add(txtContactName, 1, 10);
            gPane.add(lblContactPhone, 0, 11);
            gPane.add(txtContactPhone, 1, 11);
            gPane.add(lblContactAddress, 0, 12);
            gPane.add(txtContactAddress, 1, 12);
            gPane.add(btnSubmit, 0, 13);
            
            
            
            
            
            btnSubmit.setOnAction((a) -> {
                
                String name = txtName.getText();
                int SSN = Integer.valueOf(txtSSN.getText());
                int studentID = Integer.valueOf(txtStudentID.getText());
                String address = txtAddress.getText();
                String email = txtEmail.getText();
                double gpa = Double.valueOf(txtGPA.getText());
                String[] contactList = {txtContactName.getText(), txtContactPhone.getText(), txtContactAddress.getText()};
                
                String contactName = txtContactName.getText();
                String contactPhone = txtContactPhone.getText();
                String contactAddress = txtContactAddress.getText();
                
              String sqlStudent = "INSERT INTO STUDENT VALUES (" + "\'" + name + "\', " + SSN + ", " + studentID + ", \'" + 
                      address + "\', '" + email + "\', \'" + contactName 
                      + "\', \'" + contactPhone + "\', \'" + contactAddress + "\', " + gpa + ")";
                      
                     
                
                App.runDBQuery(sqlStudent, 'c');
                
                Student s1 = new Student(name,SSN,studentID, address, email, gpa, contactList);
                 
                App.studentArray.add(s1);
                
            
                lblName.setText(null);
                txtName.setVisible(false);
                lblSSN.setText(null);
                txtSSN.setVisible(false);
                txtStudentID.setVisible(false);
                lblstudentID.setText(null);
                txtAddress.setVisible(false);
                lblAddress.setText(null);
                txtEmail.setVisible(false);
                lblEmail.setText(null);
                lblGPA.setText(null);
                txtGPA.setVisible(false);
                lblContactName.setText(null);
                txtContactName.setVisible(false);
                lblContactPhone.setText(null);
                txtContactPhone.setVisible(false);
                lblContactAddress.setText(null);
                txtContactAddress.setVisible(false);
                btnSubmit.setVisible(false);
            
            
            
            
            
            Alert alert = new Alert(AlertType.NONE, "Record Created", new ButtonType("OK"));   
            alert.setTitle("Alert");
            alert.setHeaderText("A New Record Was Created");
            alert.setResizable(true);
            alert.setContentText("You Can Close This Box Now");
            alert.showAndWait();
            
            
            

            });
            
            
            
    });
        
        
    createCourse.setOnAction(e -> {
        
        
        
            Label lblID = new Label("Enter course ID");
            TextField txtID = new TextField();
            Label lblPrefix = new Label("Enter course prefix");
            TextField txtPrefix = new TextField();
            Label lblCourseNum = new Label("Enter course number");
            TextField txtCourseNum = new TextField();
            Label lblCourseName = new Label("Enter course name");
            TextField txtCourseName = new TextField();
            Label lblDays = new Label("Enter course days of week");
            TextField txtDays = new TextField();
            Label lblTimeStart = new Label("Enter time start");
            TextField txtTimeStart = new TextField();
            Label lblTimeEnd = new Label("Enter time end");
            TextField txtTimeEnd = new TextField();
            Label lblCredit = new Label("Enter enter credit hours");
            TextField txtCredit = new TextField();
            Button btnSubmit = new Button("Submit");
            
            
            gPane.add(lblID, 0, 4);
            gPane.add(txtID, 1, 4);
            gPane.add(lblPrefix, 0, 5);
            gPane.add(txtPrefix, 1, 5);
            gPane.add(lblCourseNum, 0, 6);
            gPane.add(txtCourseNum, 1, 6);
            gPane.add(lblCourseName, 0, 7);
            gPane.add(txtCourseName, 1, 7);
            gPane.add(lblDays, 0, 8);
            gPane.add(txtDays, 1, 8);
            gPane.add(lblTimeStart, 0, 9);
            gPane.add(txtTimeStart, 1, 9);
            gPane.add(lblTimeEnd, 0, 10);
            gPane.add(txtTimeEnd, 1, 10);
            gPane.add(lblCredit, 0, 11);
            gPane.add(txtCredit, 1, 11);
            
            gPane.add(btnSubmit, 0, 12);
            
            
            btnSubmit.setOnAction((a) -> {
                
                
                int courseID = Integer.valueOf(txtID.getText());
                String prefix = txtPrefix.getText();
                int courseNum = Integer.valueOf(txtCourseNum.getText());
                String courseName = txtCourseName.getText();
                int days = Integer.valueOf(txtDays.getText());
                String timeStart = txtTimeStart.getText();
                String timeEnd = txtTimeEnd.getText();
                int creditHr = Integer.valueOf(txtCredit.getText());
                
                
                String sqlCourse = "INSERT INTO COURSE VALUES (" +   courseID + ", '"+ prefix + "\', "
                        + courseNum + ", \'" + courseName + "\', " + days + ", '" + timeStart + "\', '" + timeEnd + "\', " + creditHr + ")";
               
                App.runDBQuery(sqlCourse, 'c');
                
                Course c1 = new Course(courseID, prefix, courseNum, courseName, days, timeStart, timeEnd, creditHr);
                
                App.courseArray.add(c1);
                   
                    
                lblID.setText(null);
                txtID.setVisible(false);
                lblPrefix.setText(null);
                txtPrefix.setVisible(false);
                txtCourseNum.setVisible(false);
                lblCourseNum.setText(null);
                txtCourseName.setVisible(false);
                lblCourseName.setText(null);
                txtDays.setVisible(false);
                lblDays.setText(null);
                lblTimeStart.setText(null);
                txtTimeStart.setVisible(false);
                lblTimeEnd.setText(null);
                txtTimeEnd.setVisible(false);
                lblCredit.setText(null);
                txtCredit.setVisible(false);
                btnSubmit.setVisible(false);
                

                
                
                Alert alert = new Alert(AlertType.NONE, "Record Created", new ButtonType("OK"));   
                alert.setTitle("Alert");
                alert.setHeaderText("A New Record Was Created");
                alert.setResizable(true);
                alert.setContentText("You Can Close This Box Now");
                alert.showAndWait();
                
                
            });

        
        
        
         });
    
    
    
    createFaculty.setOnAction(e -> {
        
        
            Label lblFacultyID = new Label("Enter Faculty ID");
            TextField txtFacultyID = new TextField();
            Label lblEmplName = new Label("Enter faculty name");
            TextField txtEmplName = new TextField();
            Label lblEmplEmail = new Label("Enter email");
            TextField txtEmplEmail = new TextField();
            Label lblBuilding = new Label("Enter office building");
            TextField txtBuilding = new TextField();
            Label lblOfficeNum = new Label("Enter office number");
            TextField txtOfficeNum = new TextField();
            Label lblEmplPhone = new Label("Enter phone #");
            TextField txtEmplPhone = new TextField();
            Label lblDept = new Label("Enter department");
            TextField txtDept = new TextField();
            Label lblPosition = new Label("Enter enter position");
            TextField txtPosition = new TextField();
            Button btnSubmit = new Button("Submit");
            
            
            
            gPane.add(lblFacultyID, 0, 4);
            gPane.add(txtFacultyID, 1, 4);
            gPane.add(lblEmplName, 0, 5);
            gPane.add(txtEmplName, 1, 5);
            gPane.add(lblEmplEmail, 0, 6);
            gPane.add(txtEmplEmail, 1, 6);
            gPane.add(lblBuilding, 0, 7);
            gPane.add(txtBuilding, 1, 7);
            gPane.add(lblOfficeNum, 0, 8);
            gPane.add(txtOfficeNum, 1, 8);
            gPane.add(lblEmplPhone, 0, 9);
            gPane.add(txtEmplPhone, 1, 9);
            gPane.add(lblDept, 0, 10);
            gPane.add(txtDept, 1, 10);
            gPane.add(lblPosition, 0, 11);
            gPane.add(txtPosition, 1, 11);
            
            gPane.add(btnSubmit, 0, 12);
            
            
            btnSubmit.setOnAction((a) -> {
                
                
                
                int facultyID = Integer.valueOf(txtFacultyID.getText());
                String emplName = txtEmplName.getText();
                String emplEmail = txtEmplEmail.getText();
                String building = txtBuilding.getText();
                int officeNum = Integer.valueOf(txtOfficeNum.getText());
                String emplPhone = txtEmplPhone.getText();
                String dept = txtDept.getText();
                String position = txtPosition.getText();
                
                String sqlFaculty = "INSERT INTO FACULTY VALUES (" + facultyID + ", \'" + emplName + "\', \'"
                        + emplEmail + "\', '" + building + "\', " + officeNum + ", \'" + emplPhone + "\', '" + dept + "\', \'" + position + "')";
                
                App.runDBQuery(sqlFaculty, 'c');
                
                Faculty f1 = new Faculty(facultyID, emplName, emplEmail, building, officeNum, emplPhone, dept, position);
               
                App.facultyArray.add(f1);
                    
                
            
                lblFacultyID.setText(null);
                txtFacultyID.setVisible(false);
                lblEmplName.setText(null);
                txtEmplName.setVisible(false);
                txtEmplEmail.setVisible(false);
                lblEmplEmail.setText(null);
                txtBuilding.setVisible(false);
                lblBuilding.setText(null);
                txtOfficeNum.setVisible(false);
                lblOfficeNum.setText(null);
                lblEmplPhone.setText(null);
                txtEmplPhone.setVisible(false);
                lblDept.setText(null);
                txtDept.setVisible(false);
                lblPosition.setText(null);
                txtPosition.setVisible(false);
                btnSubmit.setVisible(false);
                

                
                
                
                
                Alert alert = new Alert(AlertType.NONE, "Record Created", new ButtonType("OK"));   
                alert.setTitle("Alert");
                alert.setHeaderText("A New Record Was Created");
                alert.setResizable(true);
                alert.setContentText("You Can Close This Box Now");
                alert.showAndWait();
                
                
                
        
            });
        
        
             });
    
    
    
    createSemester.setOnAction((e) -> {
        
        
        
        Label lblPeriod = new Label("Enter semester period (fall, spring, summer)");
        TextField txtPeriod = new TextField();
        Label lblYear = new Label("Enter semester year");
        TextField txtYear = new TextField();
        Button btnSubmit = new Button("Submit");

        
        
        gPane.add(lblPeriod, 0,4);
        gPane.add(txtPeriod, 1,4);
        gPane.add(lblYear, 0,5);
        gPane.add(txtYear, 1,5);
        gPane.add(btnSubmit, 0,6);
        
        
        btnSubmit.setOnAction((a) -> {
           
            //the if block checks in the user entered in values for period and year
            //if they did not, an error message appears and they are prompted to try again
            //if both fields have data, the else statement runs and the semester is added to semester array
            
            if (txtPeriod.getText().isEmpty() || txtYear.getText().isEmpty())
            {
                Alert alert = new Alert(AlertType.NONE, "Empty Field", new ButtonType("OK"));   
                alert.setTitle("Alert");
                alert.setHeaderText("A Field Was Left Empty");
                alert.setResizable(true);
                alert.setContentText("Please Try Again");
                alert.showAndWait();
            }
            
            
            else
            {
           
                String semesterPeriod = txtPeriod.getText();
                int semesterYear = Integer.valueOf(txtYear.getText());


                String sqlSemester = "INSERT INTO Semester VALUES (" + "\'" + semesterPeriod + "\', " + semesterYear + ")";
                      
                     
                
                App.runDBQuery(sqlSemester, 'c');
            
                Semester sem1 = new Semester(semesterPeriod, semesterYear);
            
                App.semesterArray.add(sem1);
            
            
            
                lblPeriod.setText(null);
                txtPeriod.setVisible(false);
                lblYear.setText(null);
                txtYear.setVisible(false);
                btnSubmit.setVisible(false);


                Alert alert = new Alert(AlertType.NONE, "Record Created", new ButtonType("OK"));   
                alert.setTitle("Alert");
                alert.setHeaderText("A New Record Was Created");
                alert.setResizable(true);
                alert.setContentText("You Can Close This Box Now");
                alert.showAndWait();
           
            }
            
        });

        
        
        });
    

        
    }
    
}
