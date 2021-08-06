package com.company.objects;

import com.company.dbhelper.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static void print(){
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
    //create table scores( id INT auto_increment,
    // Mathematics INT NOT NULL,
    // English INT NOT NULL,
    // student id INT,
    //FOREIGN KEY (student id) REFERENCES students(id),
    //PRIMARY KEY (id));
}
