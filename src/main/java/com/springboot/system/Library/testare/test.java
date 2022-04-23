package com.springboot.system.Library.testare;

import com.springboot.system.Library.utilities.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws SQLException {
        DBConnection.connectToDb();
        Connection connection = DBConnection.getConnection();

        String sql = "select * from employees";
        Statement statement = connection.createStatement();
        var ceva = statement.executeQuery(sql);

        System.out.println(ceva);
        System.out.println(ceva.getString(1));

        DBConnection.disconnectToDb();

    }
}
