
package com.mycompany.projpart3;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.scene.control.Alert.AlertType;

public class Enroll {
    
    public App parentWindow;
    
    public Enroll(App parentWindow)
    {
        this.parentWindow = parentWindow;
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 450, 400);
        Stage primaryStage = new Stage();
        
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Enroll a Student");
        primaryStage.show();
     
        //choice box student list
        ArrayList<String> namelist = new ArrayList<>();
        for (int i = 0; i < App.studentArray.size(); i ++)
        {
            namelist.add(App.studentArray.get(i).studentName);
        }
    
        Label studentLabel = new Label("Choose a Student");
        gPane.add(studentLabel, 0 , 1);
        ChoiceBox studentBox = new ChoiceBox(FXCollections.observableArrayList(namelist));
        gPane.add(studentBox, 1, 1);
        
        
        //choice box course list
        ArrayList<String> courseList = new ArrayList<>();
        for (int i = 0; i < App.courseArray.size(); i ++)
        {
            courseList.add(App.courseArray.get(i).courseName);
        }
        
        Label courseLabel = new Label("Choose a Course");
        gPane.add(courseLabel, 0, 2);
        ChoiceBox courseBox = new ChoiceBox(FXCollections.observableArrayList(courseList));
        gPane.add(courseBox, 1, 2);
        
        //choice box year and period list
        ArrayList<Integer> yearList = new ArrayList<>();
        for (int i = 0; i < App.semesterArray.size(); i ++)
        {
            yearList.add(App.semesterArray.get(i).year);
        }
        
        ArrayList<String> periodList = new ArrayList<>();
        for (int i = 0; i < App.semesterArray.size(); i ++)
        {
            periodList.add(App.semesterArray.get(i).period);
        }
        
        
        Label semesterYearLabel = new Label("Choose a Semester Year");
        Label semesterPeriodLabel = new Label("Choose a Semester Period");
        gPane.add(semesterYearLabel, 5, 1);
        gPane.add(semesterPeriodLabel, 5, 2);
        
        ChoiceBox yearBox = new ChoiceBox(FXCollections.observableArrayList(yearList));
        ChoiceBox periodBox = new ChoiceBox(FXCollections.observableArrayList(periodList));
        gPane.add(yearBox, 6, 1);
        gPane.add(periodBox, 6, 2);
        
        
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 3);
        
        submitBtn.setOnAction(c -> {
           
            String selectedName = (String)studentBox.getValue();
            String selectedCourse = (String)courseBox.getValue();
            Integer selectedYear = (Integer) yearBox.getValue();
            int selectedYearInt = selectedYear;
            String selectedPeriod = (String)periodBox.getValue();
            
            
            int selectedStudentPosition = 0;
            for (int i = 0; i < App.studentArray.size(); i++)
                {
                    if (selectedName.equals(App.studentArray.get(i).studentName))
                    {
                        selectedStudentPosition = i;
                        break;
                    }
                }
            
            
            
            int selectedCoursePosition = 0;
            for (int i = 0; i < App.courseArray.size(); i++)
                {
                    if (selectedCourse.equals(App.courseArray.get(i).courseName))
                    {
                        selectedCoursePosition = i;
                        break;
                    }
                }
            
            
            int selectedSemesterPosition = 0;
            for (int i = 0; i < App.semesterArray.size(); i++)
                {
                    if (selectedYearInt == App.semesterArray.get(i).year && selectedPeriod.equals(App.semesterArray.get(i).period))
                    {
                        selectedSemesterPosition = i;
                        break;
                    }
                }
            
            
            Enrollment e1 = new Enrollment(App.studentArray.get(selectedStudentPosition),
                    App.courseArray.get(selectedCoursePosition), App.semesterArray.get(selectedSemesterPosition));
            
            App.studentEnrollmentArray.add(e1);
            
            
            
            alertMethod();
        });
        
    
    
    }
    
    
    public static void alertMethod()
    {
        Alert alert = new Alert(AlertType.NONE, "Student Enrolled", new ButtonType("OK"));   
            alert.setTitle("Alert");
            alert.setHeaderText("A Student Was Enrolled");
            alert.setResizable(true);
            alert.setContentText("You Can Close This Box Now");
            alert.showAndWait();
    }
    
}
