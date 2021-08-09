package com.company.controllers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Student;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentController {
   private static Scanner scanner = new Scanner(System.in);
   private static  PreparedStatement ps;
   private static ResultSet rs;
   //database tanya_project table students

    public static boolean addNewStudent(){

        System.out.println("Enter the name of the student: ");
        String name = scanner.next();

        System.out.println("Enter age: ");
        int age = scanner.nextInt();



        try {
            ps = DbConnection.dbConn().prepareStatement("INSERT INTO students(name, age)" +
                    "VALUES ('" + name + "', " + age + ")");

            ps.execute();
            System.out.println("successfully added to database");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteStudent(){

        int id = getStudentById().getId();

        try {
            ps = DbConnection.dbConn().prepareStatement("DELETE FROM students WHERE id = " + id);
            ps.execute();

            System.out.println("successfully removed to database");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean editStudent(){

        int id = getStudentById().getId();

        System.out.println("Name, age");
        System.out.println("Which column you want to edit?");
        String column = scanner.next().trim();

        System.out.println("Enter changed data");
        String update = scanner.next().trim();



        try {
            if( column.equals("name")){
                ps = DbConnection.dbConn().prepareStatement("UPDATE students SET " + column + " = '"+ update +"' WHERE id =" + id);
              ps.execute();}
            else if( column.equals("age")){


                ps = DbConnection.dbConn().prepareStatement("UPDATE students SET " + column + " = " + update + " WHERE id =" + id);
                ps.execute();
            } else {
                System.out.println("Update failed. Please check data and try again.");
            }

            System.out.println("successfully updated");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static Student getStudentById(){

        System.out.println("Enter the ID of the student: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.dbConn().prepareStatement("SELECT * FROM students WHERE id =" + id);
            rs = ps.executeQuery();

            int studentID, age;
            String name;

            Student student = new Student();

            while(rs.next()){
                studentID = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setId(studentID);
                student.setName(name);
                student.setAge(age);
                System.out.println(studentID + "\t " + name + "\t " + age + "\t ");
            }
            return student;






        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }



    }


}
