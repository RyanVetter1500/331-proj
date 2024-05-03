/*
Bilal Asif, Ryan Vetter, Akhil Reddy
4/28/2024

This file prints reports for a students schedule and all the students enrolled in a particular course


*/
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


import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;



public class showStudentCourseInfo {
    
    
    public App parentWindow;
    
    public showStudentCourseInfo(App parentWindow)
    {
        this.parentWindow = parentWindow;
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 450, 400);
        Stage primaryStage = new Stage();
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Show Student Course Info");
        primaryStage.show();
        
        
        
        
        Label studentSchedule = new Label("Show Courses Student is Enrolled In");
        Button studentSchedButton = new Button("Go");
        gPane.add(studentSchedule, 0 ,0 );
        gPane.add(studentSchedButton, 0 ,1 );
        
        Label classRoster = new Label("Show Class Roster for Course");
        Button classRosterButton = new Button("Go");
        gPane.add(classRoster, 4 ,0 );
        gPane.add(classRosterButton, 4 ,1 );
        
        //for viewing a students schedule
        studentSchedButton.setOnAction(a -> {
            
            
            
            ArrayList<String> namelist = new ArrayList<>();
        for (int i = 0; i < App.studentArray.size(); i ++)
        {
            namelist.add(App.studentArray.get(i).studentName);
        }
    
        
        Label studentLabel = new Label("Choose a Student");
        gPane.add(studentLabel, 0 , 2);
        ChoiceBox studentBox = new ChoiceBox(FXCollections.observableArrayList(namelist));
        gPane.add(studentBox, 1, 2);
        
        
        
        
        //loop to get semester year and put them in list for choice box
        ArrayList<Integer> yearList = new ArrayList<>();
        for (int i = 0; i < App.semesterArray.size(); i ++)
        {
            yearList.add(App.semesterArray.get(i).year);
        }
        
        //loop to get semester period and put them in list for choice box
        ArrayList<String> periodList = new ArrayList<>();
        for (int i = 0; i < App.semesterArray.size(); i ++)
        {
            periodList.add(App.semesterArray.get(i).period);
        }
        
        Label semesterYearLabel = new Label("Choose a Semester Year");
        Label semesterPeriodLabel = new Label("Choose a Semester Period");
        gPane.add(semesterYearLabel, 0, 4);
        gPane.add(semesterPeriodLabel, 0, 5);
        
        ChoiceBox yearBox = new ChoiceBox(FXCollections.observableArrayList(yearList));
        ChoiceBox periodBox = new ChoiceBox(FXCollections.observableArrayList(periodList));
        gPane.add(yearBox, 1, 4);
        gPane.add(periodBox, 1, 5);
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 6);
        
        
        submitBtn.setOnAction(w -> {
            
            String selectedName = (String)studentBox.getValue();
            Integer selectedYear = (Integer) yearBox.getValue();
            int selectedYearInt = selectedYear;
            String selectedPeriod = (String)periodBox.getValue();
            
            
            //START OF CODE THATS CHANGED-----------------------------------------------------------------------------------------
            int selectedID = 0;
            //loop to use name to find student ID. ID is PK and we use this in query below
            for (int i = 0; i < App.studentArray.size(); i++)
            {
                if (selectedName.equals(App.studentArray.get(i).studentName))
                {
                    selectedID = App.studentArray.get(i).getStudentID();
                    break;
                }
                
            }
            
            
            
            //schedule query- finds courses for a specific student for a specific semester
            String studentScheduleSQL = "select coursename from course join enrollment " 
            + "on course.courseid = enrollment.courseid " +
            "join student " +
            "on enrollment.studentid = student.studentid " +
            "where enrollment.year = " + selectedYearInt +
                    " and enrollment.period = " + "\'" + selectedPeriod + "\'" + " and enrollment.studentid = " + selectedID;

           ObservableList<String> studentScheduleList = FXCollections.observableArrayList();
            
            App.runDBQuery(studentScheduleSQL, 'r');
            
            //have to use try catch here
            //adds each row to list
            //this query returns a table with only one column and a variable amount of rows
            
            try
            {
                while(App.jsqlResults.next())
                {
                  studentScheduleList.add(App.jsqlResults.getString(1));
                }
            }
            
            catch (SQLException sqlex)
            {
                System.out.println(sqlex.toString());
            }
            
            
            ListView<String> listViewStudentSchedule = new ListView<String>(studentScheduleList);
            gPane.add(listViewStudentSchedule, 0, 7);
            
           
                
            
            
            
            
            
        });
        
        
        
        
        
        
            
            
        });
        
        
        
        
        
        
        
        
        
        
        
        
        //prints class roster for a semester
        classRosterButton.setOnAction(l -> {
            
            
            ArrayList<String> courseList = new ArrayList<>();
            for (int i = 0; i < App.courseArray.size(); i ++)
            {
                courseList.add(App.courseArray.get(i).courseName);
            }

            Label courseLabel = new Label("Choose a course");
            gPane.add(courseLabel, 4, 2);
            ChoiceBox courseBox = new ChoiceBox(FXCollections.observableArrayList(courseList));
            gPane.add(courseBox, 5, 2);



                //loop to get semester year and put them in list for choice box
            ArrayList<Integer> yearList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i ++)
            {
                yearList.add(App.semesterArray.get(i).year);
            }

            //loop to get semester period and put them in list for choice box
            ArrayList<String> periodList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i ++)
            {
                periodList.add(App.semesterArray.get(i).period);
            }

            Label semesterYearLabel = new Label("Choose a Semester Year");
            Label semesterPeriodLabel = new Label("Choose a Semester Period");
            gPane.add(semesterYearLabel, 4, 4);
            gPane.add(semesterPeriodLabel, 4, 5);

            ChoiceBox yearBox = new ChoiceBox(FXCollections.observableArrayList(yearList));
            ChoiceBox periodBox = new ChoiceBox(FXCollections.observableArrayList(periodList));
            gPane.add(yearBox, 5, 4);
            gPane.add(periodBox, 5, 5);

            Button submitBtn = new Button("Submit");
            gPane.add(submitBtn, 4, 6);
            
            
            submitBtn.setOnAction(w -> {
                
                String selectedCourse = (String)courseBox.getValue();
                Integer selectedYear = (Integer) yearBox.getValue();
                int selectedYearInt = selectedYear;
                String selectedPeriod = (String)periodBox.getValue();
                
                //START OF CODE THATS CHANGED------------------------------------------------------------------------------------
                int selectedCourseID = 0;
                ObservableList<String> classRosterList = FXCollections.observableArrayList();
                
                
                
                //loop to use name to find course ID. ID is PK and we use this in query below
            for (int i = 0; i < App.courseArray.size(); i++)
            {
                if (selectedCourse.equals(App.courseArray.get(i).courseName))
                {
                    selectedCourseID = App.courseArray.get(i).courseID;
                    break;
                }
                
            }
                
                
                String classRosterSQL = "select studentname from student join enrollment on student.studentid = enrollment.studentid " +
                "join course on enrollment.courseid = course.courseid " +
                "where enrollment.year = " + selectedYearInt + " " + "and enrollment.period = " + "\'" + selectedPeriod + "\' " +
                       "and enrollment.courseid = " + selectedCourseID;

                App.runDBQuery(classRosterSQL, 'r');
                
                
                try
            {
                while(App.jsqlResults.next())
                {
                  classRosterList.add(App.jsqlResults.getString(1));
                }
            }
            
            catch (SQLException sqlex)
            {
                System.out.println(sqlex.toString());
            }
                
                ListView<String> listViewClassRoster = new ListView<String>(classRosterList);
                gPane.add(listViewClassRoster, 4, 7);

              
               
                
                
                
            });
            
            
            
        });
        
        
        
    }
    
}
