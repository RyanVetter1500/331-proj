/*
Bilal Asif, Ryan Vetter, Akhil Reddy
4/28/2024
This is a GUI program that enables a user to create records assosiated with a university and do things like enroll students / faculty in courses
and print reports on data

FYI we chose creating a semester to do input validation. if a field is left blank, an alert will pop up saying so


*/
package com.mycompany.projpart3;

import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.collections.*;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;



/**
 * JavaFX App
 */
public class App extends Application {
    
    //creating our arrays. they are static and at the class level so that other files in our code can access them 
    
    static ArrayList<Student> studentArray = new ArrayList<>();
    static ArrayList<Faculty> facultyArray = new ArrayList<>();
    static ArrayList<Course> courseArray = new ArrayList<>();
    static ArrayList<Semester> semesterArray = new ArrayList<>();
    static ArrayList<Enrollment> studentEnrollmentArray = new ArrayList<>();
    static ArrayList<Schedule> facultyAssignArray = new ArrayList<>();
   
    
    public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
    public static Scanner keyboardIn = new Scanner(System.in);
   
    
    public ObservableList<String> obsNameList = FXCollections.observableArrayList();
    public ListView<String> lstNameList = new ListView<>(obsNameList);

    @Override
    public void start(Stage stage) {
        
        
        
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 300, 400);
        
        try
        {
            loadData();
        }
        
        catch(SQLException sqlex)
        {
            System.out.println(sqlex.toString());
        }
        
        Button create = new Button("Create a record");
        Button edit = new Button("Edit a record");
        Button assign = new Button("Assign Faculty to course");
        Button enroll = new Button("Enroll student in course");
        Button report = new Button("Print semester report");
        Button studentCourse = new Button("Show student course info");
        
        
        
        gPane.add(create,0, 0);
        gPane.add(edit, 1, 0);        
        gPane.add(assign, 0, 1);
        gPane.add(enroll, 1, 1);
        gPane.add(report, 0, 2);
        gPane.add(studentCourse, 1, 2);
        
        stage.setScene(mainScene);
        stage.setTitle("Enrollment");
        stage.show();
        
        
        //create a record
    create.setOnAction(e -> {
    createRecord temp = new createRecord(this);
    });
        
    //edit a record
    
    edit.setOnAction(a -> {
        EditRecord temp = new EditRecord(this);
        
    });
    
    //enroll a student
    enroll.setOnAction(b -> {
        
        
        Enroll temp = new Enroll(this);
        
    });
    
    //assign a faculty to teach a class
    
    assign.setOnAction(q -> {
       
        Assign temp = new Assign(this);
        
    });
    
    //print reports regarding students and courses
    
    studentCourse.setOnAction(w -> {
            
        showStudentCourseInfo temp = new showStudentCourseInfo(this);    
        
            });
        
        
    
    report.setOnAction(u -> {
       printSemester temp = new printSemester(this);
        
        
        
        
    });
    
    
    
    }

    public static void main(String[] args) {
        launch();
    }
    
    
    
     public static void runDBQuery(String query, char queryType)
{

//queryType using crud
// r = select
//c u d - update insert delete

try
{
String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
String user = "javauser";
String pass = "javapass";

oDS = new OracleDataSource();
oDS.setURL(URL);


jsqlConn = oDS.getConnection(user, pass);
jsqlStmt = jsqlConn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

if (queryType == 'r')
{
jsqlResults = jsqlStmt.executeQuery();
}

else
{
jsqlStmt.executeUpdate();
}

}

catch (SQLException sqlex)
{
System.out.println(sqlex.toString());
}



}
     
     
public void loadData() throws SQLException
{
        
        
        String studentName;
        int ssn;
        int studentID;
        String address;
        String email;
        double gpa;
        String emergencyName;
        String emergencyPhone;
        String emergencyAddress;
        
        String studentAllQuery = "select * from Student";
        App.runDBQuery(studentAllQuery, 'r');
        
        while (jsqlResults.next())
        {
             studentName = jsqlResults.getString(1);
             studentID = jsqlResults.getInt(2);
             ssn = jsqlResults.getInt(3);
             address = jsqlResults.getString(4);
             email = jsqlResults.getString(5);
             emergencyName = jsqlResults.getString(6);
             emergencyPhone = jsqlResults.getString(7);
             emergencyAddress = jsqlResults.getString(8);
             gpa = jsqlResults.getDouble(9);
             
             String[] listTemp = {emergencyName, emergencyPhone, emergencyAddress};
             
             Student temp = new Student(studentName, ssn, studentID, address, email, gpa, listTemp);
             studentArray.add(temp);
             
            
        }
                
        int facultyID;
        String emplName;
        String emplEmail;
        String building;
        int officeNum;
        String emplPhone;
        String dept;
        String position;
        
        String facultyAllQuery = "select * from faculty";
        App.runDBQuery(facultyAllQuery, 'r');
        
        while (jsqlResults.next())
        {
             facultyID = jsqlResults.getInt(1);
             emplName = jsqlResults.getString(2);
             emplEmail = jsqlResults.getString(3);
             building = jsqlResults.getString(4);
             officeNum = jsqlResults.getInt(5);
             emplPhone = jsqlResults.getString(6);
             dept = jsqlResults.getString(7);
             position = jsqlResults.getString(8);
             
             
             
             Faculty temp = new Faculty(facultyID, emplName, emplEmail, building, officeNum, emplPhone, dept, position);
             facultyArray.add(temp);
             
            
        }
        
        
        
        
        /*
        String courseAllQuery = "select * from course";
        App.runDBQuery(courseAllQuery, 'r');
        
        
        String semesterAllQuery = "select * from semester";
        App.runDBQuery(semesterAllQuery, 'r');*/
        
     
        
        
        
        
        
        
}

}