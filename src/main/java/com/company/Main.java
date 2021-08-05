package com.company;

import com.company.controllers.StudentController;
import com.company.controllers.UserController;
import com.company.login.Login;




public class Main {
    public static void main(String[] args){


        //ternary operator
//
//        System.out.println(StudentController.addNewStudent() ? "Successfully added new student" : "Failed to add new student");
//      System.out.println("The student is: " + StudentController.getStudentById().getName());

            // ====HOMETASK====

        //Register new user

        UserController.registerUser();

        //Password check

//        Login.userLogin();


    }//End of main


}//end of class

