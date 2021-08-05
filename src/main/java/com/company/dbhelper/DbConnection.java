package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection dbConn() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(User.URL.getNb(), User.USER.getNb(), User.PASSWORD.getNb());
        } catch (
                SQLException e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
