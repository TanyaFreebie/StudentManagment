package com.company.controllers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Student;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            }
            return student;





        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }



    }
}
