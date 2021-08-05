package com.company.controllers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

// database tanya_project table users
    public static boolean addNewUser() {
        System.out.println("Enter login: ");
        String login = scanner.next();

        System.out.println("Enter password: ");
        String test = scanner.next();

        System.out.println("Retype your password: ");
        String password = scanner.next();

        if(password.equals(test)){
            try {
                ps = DbConnection.dbConn().prepareStatement("INSERT INTO users(username, password)" +
                    "VALUES ('" + login + "', '" + password + "')");

                 ps.execute();
                return true;

            } catch (Exception e) {
                 e.printStackTrace();
                 return false;
             }
        } else{
            System.out.println("Password doesn't match");
            return false;
        }
    }//end of addNewUser

    public static void registerUser(){
        System.out.println(addNewUser() ? "Registration successful" : "Registration failed. If passwords match, then login probably is taken");
    }

}//end of class
