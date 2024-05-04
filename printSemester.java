package com.mycompany.dbxjavafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;
import java.util.ArrayList;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;

public class printSemester {
    
    public App parentWindow;
    
    public printSemester(App parentWindow)
    {
        this.parentWindow = parentWindow;
        
        Button printSem = new Button("Print All Courses in a Semester");
        Button printFac = new Button("Print All Courses taught by a Faculty member");
        
        
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 600, 100);
        Stage primaryStage = new Stage();
        
        gPane.add(printSem, 0, 0);
        gPane.add(printFac, 2, 0);
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Print Courses");
        primaryStage.show();
        
        printSem.setOnAction(e -> {
            
            
            Label period = new Label(" Select Semester Period: ");
            Label year = new Label(" Select Semester Year: ");
            
            ArrayList<String> periodList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i++)
            {
               periodList.add(App.semesterArray.get(i).period);
            }
            ChoiceBox periodChoice = new ChoiceBox(
                FXCollections.observableArrayList(periodList));
            
            ArrayList<Integer> yearList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i++)
            {
               yearList.add(App.semesterArray.get(i).year);
            }
            ChoiceBox yearChoice = new ChoiceBox(
                FXCollections.observableArrayList(yearList));
            
            Button btnSubmit = new Button("Submit");
            
            GridPane kPane = new GridPane();
            Scene secondScene = new Scene(kPane, 500, 500);
            Stage secondaryStage = new Stage();
            
          
            kPane.add(period, 0, 4);
           
            kPane.add(periodChoice, 1, 4);
            kPane.add(year, 4, 4);
            kPane.add(yearChoice, 5, 4);
            kPane.add(btnSubmit, 0,6);
            
            
            secondaryStage.setScene(secondScene);
            secondaryStage.setTitle("Choose Course and Semester");
            secondaryStage.show();
            
            btnSubmit.setOnAction((a) -> {
                
                String selectedPeriod = (String)periodChoice.getValue();
                Integer selectedYear = (Integer)yearChoice.getValue();
                int selectedYearInt = selectedYear;
                
                ObservableList<String> semesterList = FXCollections.observableArrayList();
                
//                for (int i = 0; i < App.studentEnrollmentArray.size(); i++)
//                {
//                    if (selectedPeriod.equals(App.studentEnrollmentArray.get(i).semesterInstance.period
//                    ) && selectedYearInt == App.studentEnrollmentArray.get(i).semesterInstance.year)
//                    {
//                    semesterList.add(App.studentEnrollmentArray.get(i).courseInstance.prefix + ": " + App.studentEnrollmentArray.get(i).courseInstance.courseNum + " "
//                            + App.studentEnrollmentArray.get(i).courseInstance.courseName + ", " + 
//                          "Time Start: " + App.studentEnrollmentArray.get(i).courseInstance.timeStart + " " + 
//                          "Time End: " + App.studentEnrollmentArray.get(i).courseInstance.timeEnd);
//
//                    }
//                }
                
                int selectedID = 0;
                for (int i = 0; i < App.studentEnrollmentArray.size(); i++)
                {
                    if (selectedPeriod.equals(App.studentEnrollmentArray.get(i).semesterInstance.period
                    ) && selectedYearInt == App.studentEnrollmentArray.get(i).semesterInstance.year)
                    {
                        selectedID = App.studentEnrollmentArray.get(i).courseInstance.courseID;
                        break;
                    }
                }
                
                String semesterScheduleSQL = "select coursename from course " +
                "join enrollment on course.courseid = enrollment.courseid " +
                "where enrollment.year = " + selectedYearInt + "and enrollment.period = " + "\'" +
                selectedPeriod + "\'";
                
                App.runDBQuery(semesterScheduleSQL, 'r');
            
                //have to use try catch here
                //adds each row to list
                //this query returns a table with only one column and a variable amount of rows

                try
                {
                    while(App.jsqlResults.next())
                    {
                      semesterList.add(App.jsqlResults.getString(1));
                    }
                }

                catch (SQLException sqlex)
                {
                    System.out.println(sqlex.toString());
                }
                
                
                ListView<String> listViewSemester = new ListView<String>(semesterList);
                kPane.add(listViewSemester, 0, 10);
                
                
                
                
            });
            
            
        });
        
        
        printFac.setOnAction(e -> {
            
            Label period = new Label(" Select Semester Period: ");
            Label year = new Label(" Select Semester Year: ");
            Label faculty = new Label("Choose a Faculty Member");
            
            ArrayList<String> periodList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i++)
            {
               periodList.add(App.semesterArray.get(i).period);
            }
            ChoiceBox periodChoice = new ChoiceBox(
                FXCollections.observableArrayList(periodList));
            
            ArrayList<Integer> yearList = new ArrayList<>();
            for (int i = 0; i < App.semesterArray.size(); i++)
            {
               yearList.add(App.semesterArray.get(i).year);
            }
            ChoiceBox yearChoice = new ChoiceBox(
                FXCollections.observableArrayList(yearList));
            
            ArrayList<String> namelist = new ArrayList<>();
            for (int i = 0; i < App.facultyArray.size(); i ++)
            {
                namelist.add(App.facultyArray.get(i).emplName);
            }
            ChoiceBox facultyBox = new ChoiceBox(
                FXCollections.observableArrayList(namelist));
            
            Button btnSubmit = new Button("Submit");
            
            GridPane oPane = new GridPane();
            Scene secondScene = new Scene(oPane, 800, 500);
            Stage secondaryStage = new Stage();
            
            oPane.add(period, 2, 4);
            oPane.add(periodChoice, 3, 4);
            oPane.add(year, 4, 4);
            oPane.add(yearChoice, 5, 4);
            oPane.add(faculty, 0, 4);
            oPane.add(facultyBox, 1, 4);
            oPane.add(btnSubmit, 0,6);
            
            
            secondaryStage.setScene(secondScene);
            secondaryStage.setTitle("Choose Faculty, Course, and Semester");
            secondaryStage.show();
            
            btnSubmit.setOnAction(k -> {
                
                String selectedName = (String)facultyBox.getValue();
                Integer selectedYear = (Integer)yearChoice.getValue();
                int selectedYearInt = selectedYear;
                String selectedPeriod = (String)periodChoice.getValue();
                
                ObservableList<String> facultyCourses = FXCollections.observableArrayList();
                
                // CHANGED CODE
//                for(int i =0; i < App.facultyAssignArray.size(); i++)
//                {
//                    if ( selectedName.equals(App.facultyAssignArray.get(i).facultyInstance.emplName)
//                        && selectedYearInt == App.facultyAssignArray.get(i).semesterInstance.year
//                        && selectedPeriod.equals(App.facultyAssignArray.get(i).semesterInstance.period ))
//                    {
//                          facultyCourses.add(App.facultyAssignArray.get(i).courseInstance.prefix + ": " + 
//                          App.facultyAssignArray.get(i).courseInstance.courseName + ", " + 
//                          "Time Start: " + App.facultyAssignArray.get(i).courseInstance.timeStart + " " + 
//                          "Time End: " + App.facultyAssignArray.get(i).courseInstance.timeEnd);
//
//                    }
//                }
                
                int selectedID = 0;
                // loop to find facultyID as PK
                for (int i = 0; i < App.facultyAssignArray.size(); i++)
                {
                    if (selectedName.equals(App.facultyAssignArray.get(i).facultyInstance.emplName) 
                        && selectedYearInt == App.facultyAssignArray.get(i).semesterInstance.year
                        && selectedPeriod.equals(App.facultyAssignArray.get(i).semesterInstance.period))
                    {
                        selectedID = App.facultyAssignArray.get(i).facultyInstance.getFacultyID();
                        break;
                    }
                }
                
                String facultyScheduleSQL = "select coursename from course join schedule on course.courseid = schedule.courseid " +
                "join faculty on schedule.facultyid = faculty.facultyid" +
                " where schedule.year = " + selectedYearInt + " and schedule.period = " + "\'" + selectedPeriod + "\'" +
                        " and schedule.facultyid = " + selectedID;
                
                App.runDBQuery(facultyScheduleSQL, 'r');
                
                try
                {
                    while(App.jsqlResults.next())
                    {
                      facultyCourses.add(App.jsqlResults.getString(1));
                    }
                }
            
                catch (SQLException sqlex)
                {
                    System.out.println(sqlex.toString());
                }
                
                
                
                
                ListView<String> listViewFaculty = new ListView<String>(facultyCourses);
                oPane.add(listViewFaculty, 0, 10);
                
                
            });
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
