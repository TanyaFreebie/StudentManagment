package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection dbConn() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(User.URL.getPc(), User.USER.getPc(), User.PASSWORD.getPc());
        } catch (
                SQLException e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
