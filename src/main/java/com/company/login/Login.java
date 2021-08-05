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
    // database tanya_project table users
    public static void userLogin() {
        //request data from user
        System.out.println("Enter your login: ");
        String login = scanner.next();


        System.out.println("Enter your password: ");
        String password = scanner.next();
        //HARCODING
//        String login = "admin";
//        String password = "gfwugfue";

        try {
          ps = DbConnection.dbConn().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();



            //printout requested line
            String loginT, passwordT;


//            System.out.println("username\t password\t");//printout data for checking

            while(rs.next()) {


                loginT = rs.getString("username");// for printing data
                passwordT = rs.getString("password");
//                System.out.println(loginT + "\t " + passwordT + "\t ");//printout data for checking

                if(password.equals(passwordT)) {
                    System.out.println("Access granted");
                }else {
                    System.out.println("Login failed. Check login/password");
                }



            }//end of line request



        } catch (Exception e) {
            e.printStackTrace();

        }
    }//end of addNewUser



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
