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

}
