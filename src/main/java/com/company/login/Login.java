package com.company.login;

import com.company.dbhelper.DbConnection;
import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //table users

    public static void userLogin() {
        System.out.println("Sing in");//Welcome message

        //request username from user
        System.out.println("Enter your username: ");
        String login = scanner.next();



        try {
          ps = DbConnection.dbConn().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();

            //set variable for validation
            String  passwordCheck;


         // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username excepted.");

                //asking for password from user
                System.out.println("Enter your password: ");
                String password = scanner.next();

                passwordCheck = rs.getString("password");

                //Check if password is correct
                boolean correct = password.equals(passwordCheck);
                if(correct) {
                        System.out.println("Access granted.");
                    } else {
                        System.out.println("Login failed. Check password");
                    }
                } else {
                System.out.println("Username doesn't exists");
            }



        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    public  static void printTable()  {
       try{
           ps = DbConnection.dbConn().prepareStatement("SELECT * FROM users;");
        rs = ps.executeQuery();
        String login, password;
        int id;

        System.out.println("ID\t login\t password\t");

        while(rs.next()) {
            id = rs.getInt("id");
            login = rs.getString("username");
            password = rs.getString("password");

            System.out.println(id + "\t " + login + "\t " + password + "\t ");
        }


    } catch (
    SQLException e) {
        e.printStackTrace();
    }

    }//end of test
}
