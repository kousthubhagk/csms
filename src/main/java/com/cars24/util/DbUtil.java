package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection dbConnection;
    public static Connection getDbConnection(){

        if (dbConnection == null) {

            try {
                dbConnection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
                System.out.println("Connection successful!");
//            return dbConnection;
            } catch (SQLException e) {
                System.out.println("Error connecting to the database");

            }
        }
        return dbConnection;
    }

    public static void closeConnection() {
        if (dbConnection != null) {
            try {
                dbConnection.close();
                dbConnection = null; // Reset the connection
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }

}
