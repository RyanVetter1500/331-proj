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



/**
 * JavaFX App
 */
public class App extends Application {
    
    
    static ArrayList<Student> studentArray = new ArrayList<>();
    static ArrayList<Faculty> facultyArray = new ArrayList<>();
    static ArrayList<Course> courseArray = new ArrayList<>();
    static ArrayList<Semester> semesterArray = new ArrayList<>();
    static ArrayList<Enrollment> studentEnrollmentArray = new ArrayList<>();
    static ArrayList<Schedule> facultyAssignArray = new ArrayList<>();
   
    
    
   
    
    public ObservableList<String> obsNameList = FXCollections.observableArrayList();
    public ListView<String> lstNameList = new ListView<>(obsNameList);

    @Override
    public void start(Stage stage) {
        
        
        
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 300, 400);
        
        
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
        
        
    create.setOnAction(e -> {
    createRecord temp = new createRecord(this);
    });
        
    
    edit.setOnAction(a -> {
        EditRecord temp = new EditRecord(this);
        
    });
    
    
    enroll.setOnAction(b -> {
        
        
        Enroll temp = new Enroll(this);
        
    });
    
    
    assign.setOnAction(q -> {
       
        Assign temp = new Assign(this);
        
    });
    
    
    studentCourse.setOnAction(w -> {
            
        showStudentCourseInfo temp = new showStudentCourseInfo(this);    
        
            });
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}