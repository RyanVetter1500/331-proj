
package com.mycompany.dbxjavafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.scene.control.Alert.AlertType;
import java.util.*;


public class EditRecord {
    
    public App parentWindow;
    
    public EditRecord(App parentWindow)
    {
        //creating secondary window
        
        this.parentWindow = parentWindow;
    
        GridPane gPane = new GridPane();
        Scene mainScene = new Scene(gPane, 500, 500);
        Stage primaryStage = new Stage();
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Edit a Record");
        primaryStage.show();
        
        
        //using loop to get names from student array and putting them in another array to use for choic box
        ArrayList<String> namelist = new ArrayList<>();
        for (int i = 0; i < App.studentArray.size(); i ++)
        {
            namelist.add(App.studentArray.get(i).studentName);
        }
    
        
        Label studentLabel = new Label("Edit a student");
        gPane.add(studentLabel, 0 , 1);
        ChoiceBox studentBox = new ChoiceBox(FXCollections.observableArrayList(namelist));
        gPane.add(studentBox, 1, 1);
        
        
        //loop to get course names and put them in a new list for choice box
         ArrayList<String> courseList = new ArrayList<>();
        for (int i = 0; i < App.courseArray.size(); i ++)
        {
            courseList.add(App.courseArray.get(i).courseName);
        }
        
        Label courseLabel = new Label("Edit a course");
        gPane.add(courseLabel, 0, 2);
        ChoiceBox courseBox = new ChoiceBox(FXCollections.observableArrayList(courseList));
        gPane.add(courseBox, 1, 2);
        
        //loop to get faculty names and put them in list for choice box
        ArrayList<String> facultyList = new ArrayList<>();
        for (int i = 0; i < App.facultyArray.size(); i ++)
        {
            facultyList.add(App.facultyArray.get(i).emplName);
        }
        
              
        Label facultyLabel = new Label("Edit a faculty");
        gPane.add(facultyLabel, 5, 1);
        ChoiceBox facultyBox = new ChoiceBox(FXCollections.observableArrayList(facultyList));
        gPane.add(facultyBox, 6, 1);
        
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
        
        Label semesterYearLabel = new Label("Edit a Semester Year");
        Label semesterPeriodLabel = new Label("Edit a Semester Period");
        gPane.add(semesterYearLabel, 5, 2);
        gPane.add(semesterPeriodLabel, 5, 3);
        
        ChoiceBox yearBox = new ChoiceBox(FXCollections.observableArrayList(yearList));
        ChoiceBox periodBox = new ChoiceBox(FXCollections.observableArrayList(periodList));
        gPane.add(yearBox, 6, 2);
        gPane.add(periodBox, 6, 3);
        
    
    //activated once user selects a name
    
    studentBox.setOnAction(e -> {
        
        String selectedName = (String)studentBox.getValue();
        
        String[] choices = {"Name", "SSN", "Address", "Email", "GPA", "Emergency Contact Name",
            "Emergency Contact Address", "Emergency Contact Phone Number"};
        ChoiceBox studentEdit = new ChoiceBox(FXCollections.observableArrayList(choices));
        gPane.add(studentEdit, 0, 3);
        
        Label selection = new Label("What is the new value");
        TextField select = new TextField();
        
        
        gPane.add(selection, 0, 4);
        gPane.add(select, 1, 4);
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 5);
        
        
    //.getSelectionModel().getSelectedItem()should you use this???????
    //may have to override toString()

        
        //starts when user enters in new value and clicks submit
        submitBtn.setOnAction(q -> {
            
            
            
            String selectedField = (String) studentEdit.getValue();
            String newValue = (String)select.getText();

            //finds index for the instance we want 
            
            int selectedStudentPosition = 0;
            for (int i = 0; i < App.studentArray.size(); i++)
                {
                    if (selectedName.equals(App.studentArray.get(i).studentName))
                    {
                        selectedStudentPosition = i;
                        break;
                    }
                }




            //based on the field user selected to edit
            switch (selectedField)
            {

                case "Name":
                        App.studentArray.get(selectedStudentPosition).studentName = newValue;
                        String studentNameSQL = "UPDATE Student SET STUDENTNAME = " + "\'" + newValue + "\'"
                                + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                        App.runDBQuery(studentNameSQL, 'u');
                        break;

                case "SSN":
                    int selectedSSN = Integer.valueOf(newValue);
                    App.studentArray.get(selectedStudentPosition).setSSN(selectedSSN);
                    String ssnSQL = "UPDATE Student SET SSN = " + "\'" + selectedSSN + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(ssnSQL, 'u');
                    break;

                case "Address":
                    App.studentArray.get(selectedStudentPosition).address = newValue;
                    String addressSQL = "UPDATE Student SET ADDRESS = " + "\'" + newValue + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(addressSQL, 'u');
                    break;

                case "Email":
                    App.studentArray.get(selectedStudentPosition).email = newValue;
                    String emailSQL = "UPDATE Student SET EMAIL = " + "\'" + newValue + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(emailSQL, 'u');
                    break;

                case "GPA":
                    double selectedGPA = Double.valueOf(newValue);
                    App.studentArray.get(selectedStudentPosition).setgpa(selectedGPA);
                    String gpaSQL = "UPDATE Student SET GPA = " + "\'" + selectedGPA + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(gpaSQL, 'u');
                    break;


                case "Emergency Contact Name":
                    App.studentArray.get(selectedStudentPosition).contacts[0] = newValue;
                    String contactNameSQL = "UPDATE Student SET EMERGENCYCONTACTNAME = " + "\'" + newValue + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(contactNameSQL, 'u');
                    break;


                case "Emergency Contact Phone Number":
                    App.studentArray.get(selectedStudentPosition).contacts[1] = newValue;
                    String contactPhoneSQL = "UPDATE Student SET EMERGENCYCONTACTPHONE = " + "\'" + newValue + "\'"
                            + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(contactPhoneSQL, 'u');
                    break;

                case "Emergency Contact Address":
                App.studentArray.get(selectedStudentPosition).contacts[2] = newValue;
                String contactAddressSQL = "UPDATE Student SET EMERGENCYCONTACTADDRESS = " + "\'" + newValue + "\'"
                        + " WHERE Student.StudentName = " + "\'" + selectedName + "\'";
                    App.runDBQuery(contactAddressSQL, 'u');
                break;

            }
            
            
            studentEdit.setVisible(false);
            selection.setText(null);
            select.setVisible(false);
            submitBtn.setVisible(false);
            
            
            alertMethod();
        });
    });
    
    
    //happens when a course is selected from choice box- gives user option to select what data field they want to change and
    //make necessary changes
    courseBox.setOnAction(e -> {
        
        String selectedCourse = (String)courseBox.getValue();
        String[] courseOptions = {"Course ID", "Prefix", "Course Number", "Course Name", "Days", "Time Start", "Time End", "Credit Hr"};
        
        
        ChoiceBox courseEdit = new ChoiceBox(FXCollections.observableArrayList(courseOptions));
        gPane.add(courseEdit, 0, 3);
        
        Label selection = new Label("What is the new value");
        TextField select = new TextField();
        
        
        gPane.add(selection, 0, 4);
        gPane.add(select, 1, 4);
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 5);

        submitBtn.setOnAction(q -> {
            String selectedField = (String) courseEdit.getValue();
            String newValue = (String)select.getText();

            int selectedCoursePosition = 0;
            for (int i = 0; i < App.courseArray.size(); i++)
                {
                    if (selectedCourse.equals(App.courseArray.get(i).courseName))
                    {
                        selectedCoursePosition = i;
                        break;
                    }
                }





            switch (selectedField)
            {

                case "Course ID":
                        int selectedID = Integer.valueOf(newValue);
                        App.courseArray.get(selectedCoursePosition).courseID = selectedID;
                        String courseIDSQL = "UPDATE Course SET COURSEID = " + "\'" + selectedID + "\'"
                                + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                        App.runDBQuery(courseIDSQL, 'u');
                        break;

                case "Prefix":
                    App.courseArray.get(selectedCoursePosition).prefix = newValue;
                    String prefixSQL = "UPDATE Course SET PREFIX = " + "\'" + newValue + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(prefixSQL, 'u');
                    break;

                case "Course Number":
                    int selectedCourseNum = Integer.valueOf(newValue);
                    App.courseArray.get(selectedCoursePosition).courseNum = selectedCourseNum;
                    String courseNumSQL = "UPDATE Course SET COURSENUM = " + "\'" + selectedCourseNum + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(courseNumSQL, 'u');
                    break;

                case "Course Name":
                    App.courseArray.get(selectedCoursePosition).courseName = newValue;
                    String courseNameSQL = "UPDATE Course SET COURSENAME = " + "\'" + newValue + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(courseNameSQL, 'u');
                    break;

                case "days":
                    int selectedDays = Integer.valueOf(newValue);
                    App.courseArray.get(selectedCoursePosition).days = selectedDays;
                    String daysSQL = "UPDATE Course SET DAYS = " + "\'" + selectedDays + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(daysSQL, 'u');
                    break;


                case "Time Start":
                    App.courseArray.get(selectedCoursePosition).timeStart = newValue;
                    String startSQL = "UPDATE Course SET TIMESTART = " + "\'" + newValue + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(startSQL, 'u');
                    break;


                case "Time End":
                    App.courseArray.get(selectedCoursePosition).timeEnd = newValue;
                    String endSQL = "UPDATE Course SET TIMEEND = " + "\'" + newValue + "\'"
                            + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(endSQL, 'u');
                    break;

                case "Credit Hr":
                int selectedHr = Integer.valueOf(newValue); 
                App.courseArray.get(selectedCoursePosition).creditHr = selectedHr;
                String creditHrSQL = "UPDATE Course SET CREDITHOUR = " + "\'" + selectedHr + "\'"
                        + " WHERE Course.CourseName = " + "\'" + selectedCourse + "\'";
                    App.runDBQuery(creditHrSQL, 'u');
                break;

            }
            
            courseEdit.setVisible(false);
            selection.setText(null);
            select.setVisible(false);
            submitBtn.setVisible(false);
            
            alertMethod();
            
        });
        
    });
    
            
    //for editing faculty information         
    facultyBox.setOnAction(e -> {
        
        
        String selectedFaculty = (String)courseBox.getValue();
        String[] facultyOptions = {"Faculty ID", "Name", "Email", "Building", "Office Number", "Phone Number", "Department", "Position"};
        
        
        ChoiceBox facultyEdit = new ChoiceBox(FXCollections.observableArrayList(facultyOptions));
        gPane.add(facultyEdit, 0, 3);
        
        Label selection = new Label("What is the new value");
        TextField select = new TextField();
        
        
        gPane.add(selection, 0, 4);
        gPane.add(select, 1, 4);
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 0, 5);
        
        
        submitBtn.setOnAction(a -> {
            
            
            String selectedField = (String) facultyEdit.getValue();
            String newValue = (String)select.getText();

            int selectedFacultyPosition = 0;
            for (int i = 0; i < App.courseArray.size(); i++)
                {
                    if (selectedField.equals(App.facultyArray.get(i).emplName))
                    {
                        selectedFacultyPosition = i;
                        break;
                    }
                }
            
            
            switch (selectedField)
                    {
                case "Faculty ID":
                    int selectedID = Integer.valueOf(newValue);
                    App.facultyArray.get(selectedFacultyPosition).setFacultyID(selectedID);
                    String facIDSQL = "UPDATE Faculty SET FacultyID = " + "\'" + selectedID + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";       
                    App.runDBQuery(facIDSQL, 'u');      
                    break;
                case "Name":
                    App.facultyArray.get(selectedFacultyPosition).emplName = newValue;
                    String facNameSQL = "UPDATE Faculty SET EMPLNAME = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(facNameSQL, 'u');
                    break;
                case "Email":
                    App.facultyArray.get(selectedFacultyPosition).emplEmail = newValue;
                    String facEmailSQL = "UPDATE Faculty SET EMPLOYEEEMAIL = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(facEmailSQL, 'u');
                    break;
                case "Building":
                    App.facultyArray.get(selectedFacultyPosition).building = newValue;
                    String buildingSQL = "UPDATE Faculty SET building = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(buildingSQL, 'u');
                    break;
                case "Office Number":
                    int selectedNum = Integer.valueOf(newValue);
                        App.facultyArray.get(selectedFacultyPosition).officeNum = selectedNum;
                        String officeSQL = "UPDATE Faculty SET officeNum = " + "\'" + selectedNum + "\'"
                                + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                        App.runDBQuery(officeSQL, 'u');
                    break;
                case "Phone Number":
                    App.facultyArray.get(selectedFacultyPosition).emplPhone = newValue;
                    String facPhoneSQL = "UPDATE Faculty SET emplPhone = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(facPhoneSQL, 'u');
                    break;
                case "Department":
                    App.facultyArray.get(selectedFacultyPosition).dept = newValue;
                    String deptSQL = "UPDATE Faculty SET dept = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(deptSQL, 'u');
                    break;
                case "Position":
                    App.facultyArray.get(selectedFacultyPosition).position = newValue;
                    String posSQL = "UPDATE Faculty SET position = " + "\'" + newValue + "\'"
                            + " WHERE Faculty.EMPLNAME = " + "\'" + selectedFaculty + "\'";
                    App.runDBQuery(posSQL, 'u');
                    break;
                        
                    }
            
            
            facultyEdit.setVisible(false);
            selection.setText(null);
            select.setVisible(false);
            submitBtn.setVisible(false);
            
            alertMethod();
            
            
            
        });
    
        
        
    });
    
    
    //for editing semester information
    //set it to the period choice box as its the second one in the app
    periodBox.setOnAction(e -> {
        
        Integer selectedYear = (Integer) yearBox.getValue();
        int selectedYearInt = selectedYear;
        String selectedPeriod = (String)periodBox.getValue();
       
        
        
        Label whichEdit = new Label("Edit year or period?");
        gPane.add(whichEdit, 5, 4);
        
        String[] choiceList  = {"Year", "Period"};
        ChoiceBox yearOrPeriod = new ChoiceBox(FXCollections.observableArrayList(choiceList));
        gPane.add(yearOrPeriod, 6, 4);
        
        Label newValueLabel = new Label("What is the new value");
        gPane.add(newValueLabel, 5, 5);
        
        TextField newValueInput = new TextField();
        gPane.add(newValueInput, 6, 5);
        
        Button submitBtn = new Button("Submit");
        gPane.add(submitBtn, 6,6);
        
        
        submitBtn.setOnAction(a -> {
            
            
            String selectedField = (String) yearOrPeriod.getValue();
            String newValue = (String)newValueInput.getText();
            
            
            //need to add another?
            
            int selectedSemesterPosition = 0;
            for (int i = 0; i < App.semesterArray.size(); i++)
                {
                    if (selectedYear == App.semesterArray.get(i).year && selectedPeriod.equals(App.semesterArray.get(i).period))
                    {
                        selectedSemesterPosition = i;
                        break;
                    }
                }
            
            
            switch (selectedField)
            {
                case "Year":
                    int selectedSemesterYear = Integer.valueOf(newValue);
                    App.semesterArray.get(selectedSemesterPosition).year = selectedSemesterYear;
                    String editYearSQL = "UPDATE Semester SET Year = " + selectedSemesterYear + 
                            " WHERE Semester.Year = " + selectedYearInt;
                    App.runDBQuery(editYearSQL, 'u');
                    break;
                case "Period":
                    App.semesterArray.get(selectedSemesterPosition).period = newValue;
                    String editPeriodSQL = "UPDATE Semester SET Period = " + "\'" + newValue + "\'" +
                            " WHERE Semester.Period = " + selectedPeriod;
                    App.runDBQuery(editPeriodSQL, 'u');
                    break;
            }
            
            
            yearOrPeriod.setVisible(false);
            whichEdit.setText(null);
            newValueLabel.setText(null);
            newValueInput.setVisible(false);
            submitBtn.setVisible(false);
            
            alertMethod();
        
        
        });
        
        
        
        
       
        
        
        
        
        
        
    });
        
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    public static void alertMethod()
    {
        Alert alert = new Alert(AlertType.NONE, "Record Edited", new ButtonType("OK"));   
            alert.setTitle("Alert");
            alert.setHeaderText("A Record Was Edited");
            alert.setResizable(true);
            alert.setContentText("You Can Close This Box Now");
            alert.showAndWait();
    }
    
}
