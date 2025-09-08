package com.example.db_demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    public Connection connection;

    public void initDatabaseConnection() throws SQLException {
        System.out.println("Database connection initialized.");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/cinema", "root", "");
        System.out.println("Database connected successfully." + connection.isValid(5));
    }

    public void closeDatabaseConnection() throws SQLException{
    System.out.println("Closing Database Connection...");
    connection.close();
    System.out.println("Connection valid: " + connection.isClosed()  );
}
}
