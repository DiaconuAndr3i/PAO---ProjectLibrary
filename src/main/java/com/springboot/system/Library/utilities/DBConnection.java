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

    private static Boolean yesNo;
    private DBConnection(){
        jdbcURL = "jdbc:postgresql://localhost:5432/library";
        username = "postgres";
        password = "postgres";
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            yesNo = Boolean.TRUE;
            System.out.println("Established connection to the database.");
        }catch (SQLException exp){
            yesNo = Boolean.FALSE;
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

    public static Boolean getYesNo(){
        return yesNo;
    }
}
