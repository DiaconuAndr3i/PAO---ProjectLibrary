package com.springboot.system.Library.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static String jdbcURL;
    private static String username;
    private static String password;
    private static DBConnection dbConnection;
    private DBConnection(){
        jdbcURL = "jdbc:postgresql://localhost:5432/employees";
        username = "postgres";
        password = "postgres";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
        }catch (SQLException exp){
            System.out.println("Something went wrong with connection to db.");
            exp.printStackTrace();
        }
    }

    public static void connectToDb(){
        if(dbConnection == null){
          dbConnection = new DBConnection();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void disconnectToDb() throws SQLException {
        connection.close();
    }
}
