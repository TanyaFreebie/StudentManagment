package com.company.controllers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //table users

    private static boolean addNewUser() {
        System.out.println("New user registration");//Introduction

        //ask user to provide username
        System.out.println("Enter username: ");
        String login = scanner.next();

        //Check if username is already taken
        try {
            ps = DbConnection.dbConn().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("This username is taken. Try '" + login + "1'.");
                return false;

            } else {
                System.out.println("Username OK");

                //ask user to provide password
                System.out.println("Enter password: ");
                String password1 = scanner.next();

                System.out.println("Retype your password: ");
                String password2 = scanner.next();
            //check if user is able to type password twice correctly
                if(password1.equals(password2)){
                    try {
                        ps = DbConnection.dbConn().prepareStatement("INSERT INTO users(username, password)" +
                                "VALUES ('" + login + "', '" + password1 + "')");

                        ps.execute();
                        return true;

                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    System.out.println("Password doesn't match");
                    return false;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return true;

    }

    public static void registerUser(){
        System.out.println(addNewUser() ? "Registration successful" : "Registration failed.");
    }

}//end of class
