
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

            
           
            
            ObservableList<String> studentScheduleList = FXCollections.observableArrayList();

            for (int i = 0; i < App.studentEnrollmentArray.size(); i++)
            {
            if ( selectedName.equals(App.studentEnrollmentArray.get(i).studentInstance.studentName)
                 && selectedYearInt == App.studentEnrollmentArray.get(i).semesterInstance.year
                 && selectedPeriod.equals(App.studentEnrollmentArray.get(i).semesterInstance.period ))
                {
                    studentScheduleList.add("Course: " + App.studentEnrollmentArray.get(i).courseInstance.courseName + " " + 
                          "Time Start: " + App.studentEnrollmentArray.get(i).courseInstance.timeStart + " " + 
                          "Time End: " + App.studentEnrollmentArray.get(i).courseInstance.timeEnd);

                }
            
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
                
                
                ObservableList<String> classRosterList = FXCollections.observableArrayList();

                for (int i = 0; i < App.studentEnrollmentArray.size(); i++)
                {
                if ( selectedCourse.equals(App.studentEnrollmentArray.get(i).courseInstance.courseName)
                     && selectedYearInt == App.studentEnrollmentArray.get(i).semesterInstance.year
                     && selectedPeriod.equals(App.studentEnrollmentArray.get(i).semesterInstance.period ))
                    {
                        classRosterList.add(App.studentEnrollmentArray.get(i).studentInstance.studentName);

                    }

                }

                ListView<String> listViewStudentSchedule = new ListView<String>(classRosterList);
                gPane.add(listViewStudentSchedule, 4, 7);
               
                
                
                
            });
            
            
            
        });
        
        
        
    }
    
}
