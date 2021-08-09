package com.company.controllers;

import com.company.dbhelper.DbConnection;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;

import javax.security.auth.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ScoreController {
    private static Scanner scanner = new Scanner(System.in);
    private static  PreparedStatement ps;
    private static ResultSet rs;


    ////+++++ADD SCORE
    public static void addMarks(){
        System.out.println("Enter students id: ");
        int id = scanner.nextInt();



        try {

            ps = DbConnection.dbConn().prepareStatement("SELECT * FROM students WHERE id = " + id);

            rs = ps.executeQuery();




            // Check if provided student exists in database
            if (rs.next()) {
                System.out.println("Student found.");

                System.out.println("Enter Mathematics score: ");
                int mathScore = scanner.nextInt();

                System.out.println("Enter English score: ");
                int englishScore = scanner.nextInt();
                ps = DbConnection.dbConn().prepareStatement("INSERT INTO scores(student_id, Mathematics, English)" + " VALUES(" + id + ", " + mathScore + ", " + englishScore + ")");
                ps.execute();

                System.out.println("Score was updated");

            } else {
                System.out.println("Student doesn't exists. Check required students ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editScore(){
        int studentID = StudentController.getStudentById().getId();

        System.out.println("Mathematics, English");
        System.out.println("Enter subject");
        String subject = scanner.next().trim();
        System.out.println("Enter changed data");
       int update = scanner.nextInt();


        try {
            ps = DbConnection.dbConn().prepareStatement("UPDATE scores SET " + subject + " = '"+ update +"' WHERE student_id =" + studentID);
            ps.execute();
        } catch (SQLException e) {
                      e.printStackTrace();
        }


    }

    public static void deleteScore(){
        int studentID = StudentController.getStudentById().getId();

        System.out.println("Mathematics, English");
        System.out.println("Enter subject");
        String subject = scanner.next().trim();



        try {
            ps = DbConnection.dbConn().prepareStatement("UPDATE scores SET " + subject + " = NULL WHERE student_id =" + studentID);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
