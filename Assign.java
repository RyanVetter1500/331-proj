
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

public class Assign {
    
    public App parentWindow;
    
    public Assign(App parentWindow)
    {
        this.parentWindow = parentWindow;
        
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 450, 400);
        Stage primaryStage = new Stage();
        
        
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Assign a Faculty");
        primaryStage.show();
        
       
        ArrayList<String> facultyList = new ArrayList<>();
        for (int i = 0; i < App.facultyArray.size(); i ++)
        {
            facultyList.add(App.facultyArray.get(i).emplName);
        }
        
              
        Label facultyLabel = new Label("Choose a faculty");
        gPane.add(facultyLabel, 0, 0);
        ChoiceBox facultyBox = new ChoiceBox(FXCollections.observableArrayList(facultyList));
        gPane.add(facultyBox, 1, 0);
        
        
        
        ArrayList<String> courseList = new ArrayList<>();
        for (int i = 0; i < App.courseArray.size(); i ++)
        {
            courseList.add(App.courseArray.get(i).courseName);
        }
        
        Label courseLabel = new Label("Choose a course");
        gPane.add(courseLabel, 0, 1);
        ChoiceBox courseBox = new ChoiceBox(FXCollections.observableArrayList(courseList));
        gPane.add(courseBox, 1, 1);
        
        
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
        gPane.add(semesterYearLabel, 2, 0);
        gPane.add(semesterPeriodLabel, 2, 1);
        
        ChoiceBox yearBox = new ChoiceBox(FXCollections.observableArrayList(yearList));
        ChoiceBox periodBox = new ChoiceBox(FXCollections.observableArrayList(periodList));
        gPane.add(yearBox, 3, 0);
        gPane.add(periodBox, 3, 1);
        
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 2);
        
        submitBtn.setOnAction(i -> {
            
            String selectedName = (String)facultyBox.getValue();
            String selectedCourse = (String)courseBox.getValue();
            Integer selectedYear = (Integer) yearBox.getValue();
            int selectedYearInt = selectedYear;
            String selectedPeriod = (String)periodBox.getValue();
            
            
            
            int selectedCoursePosition = 0;
            for (int b = 0; b < App.courseArray.size(); b++)
                {
                    if (selectedCourse.equals(App.courseArray.get(b).courseName))
                    {
                        selectedCoursePosition = b;
                        break;
                    }
                }
            
            
            
            int selectedSemesterPosition = 0;
            for (int q = 0; q < App.semesterArray.size(); q++)
                {
                    if (selectedYearInt == App.semesterArray.get(q).year && selectedPeriod.equals(App.semesterArray.get(q).period))
                    {
                        selectedSemesterPosition = q;
                        break;
                    }
                }
            
            
            int selectedFacultyPosition = 0;
            for (int t = 0; t < App.facultyArray.size(); t++)
            {
                if (selectedName.equals(App.facultyArray.get(t).emplName))
                {
                    selectedFacultyPosition = t;
                }
            }
            
            
            Schedule sched1 = new Schedule(App.facultyArray.get(selectedFacultyPosition),
                                            App.courseArray.get(selectedCoursePosition),
                                            App.semesterArray.get(selectedSemesterPosition));
            
            
            App.facultyAssignArray.add(sched1);
            
           alertMethod();
            
        });

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    public static void alertMethod()
    {
        Alert alert = new Alert(AlertType.NONE, "Faculty Assigned", new ButtonType("OK"));   
            alert.setTitle("Alert");
            alert.setHeaderText("A Faculty Member Was Assigned");
            alert.setResizable(true);
            alert.setContentText("You Can Close This Box Now");
            alert.showAndWait();
    }
    
    
    
    
}
