package com.pluralsight;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String username = "root";
        String password = "yearup";

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. open a connection to the database
        // use the database URL to point to the correct database
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                username,
                password);


        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();

        // define your query
        String query = "SELECT * FROM products";

        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);

        // process the results
        while(results.next()){
            String productName = results.getString("ProductName");
            System.out.println(productName);
        }

        // THIS WILL CLOSE ALL CONNECTIONS
        results.close();
        statement.close();
        connection.close();
    }
}