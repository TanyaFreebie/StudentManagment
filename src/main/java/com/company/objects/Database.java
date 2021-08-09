package com.company.objects;

import com.company.dbhelper.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {


    public static void printUsers(){
        System.out.println("Connection to database..");

        PreparedStatement ps;
        ResultSet rs;

        try {


            ps = DbConnection.dbConn().prepareStatement("SELECT * from users;");
            rs = ps.executeQuery();

            //Decleare variables to hold the data you'll be getting from the result set
            int id;
            String username, password;

            System.out.println("ID\t username\t password\t");

            while (rs.next()) {
                id = rs.getInt("id");
                username = rs.getString("username");
                password = rs.getString("password");

                System.out.println(id + "\t " + username + "\t " + password + "\t ");
            }
            System.out.println("End of table");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createStudents() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = DbConnection.dbConn().prepareStatement("CREATE TABLE students(id INT AUTO_INCREMENT,\n" +
                    "Name VARCHAR(50) NOT NULL, \n" +
                    "age INT NOT NULL, \n" +
                    "PRIMARY KEY (id))");

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void createScores(){
            PreparedStatement pps;
            ResultSet rrs;
            try {
                pps = DbConnection.dbConn().prepareStatement("CREATE TABLE scores(id INT AUTO_INCREMENT,\n" +
                        "student_id INT, \n" +
                        "Mathematics INT NOT NULL, \n" +
                        "English INT NOT NULL, \n" +
                        "PRIMARY KEY (id), \n" +
                        "FOREIGN KEY (student_id) REFERENCES students(id))");

                pps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
    //create table scores( id INT AUTO_INCREMENT,
    // student id INT NOT NULL,
    // Mathematics INT NOT NULL,
    // English INT NOT NULL,
    //PRIMARY KEY (id),
    //FOREIGN KEY (student id) REFERENCES students(id));

    //ALTER TABLE tanya_project.scores MODIFY COLUMN Mathematics int(11) NULL;
}
