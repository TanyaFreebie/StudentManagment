package com.company;

import com.company.controllers.StudentController;
import com.company.controllers.UserController;
import com.company.dbhelper.DbConnection;
import com.company.login.Login;
import com.company.objects.Database;


public class Main {
    public static void main(String[] args){
        //check connection
//        DbConnection.dbConn();

//    StudentController.addNewStudent();


        //ternary operator
//
//        System.out.println(StudentController.addNewStudent() ? "Successfully added new student" : "Failed to add new student");
//      System.out.println("The student is: " + StudentController.getStudentById().getName());

            // ====HOMETASK====

        //***Register new user

//      UserController.registerUser();


        //***Password check

//        Login.userLogin();

    // ***Check whole table
//        Database.print();

        //++++ClassTask++++
        StudentController.addMarks();


    }//End of main


}//end of class

