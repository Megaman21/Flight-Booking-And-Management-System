//package com.eL.webproject;
//
//
//
//import java.sql.*;
//public class testDBmanager {
//
//    private static com.eL.webproject.testDBmanager instance = new com.eL.webproject.testDBmanager();
//    public static final String URL = "jdbc:mysql://localhost:3306/webproject";
//    public static final String USER = "root";
//    public static final String PASSWORD = "1234";
//    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
//
//    private testDBmanager() {
//        try {
//            //Step 2: Load MySQL Java driver
//            Class.forName(DRIVER_CLASS);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Connection createConnection() {
//        Connection connection = null;
//
//        try {
//            //Step 3: Establish Java MySQL connection
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException e) {
//            System.out.println("ERROR: Unable to Connect to Database.");
//        }
//        return connection;
//    }
//
//    private void closeConnection() {
//        try {
//            //Step 3: Establish Java MySQL connection
//            getConnection().close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() {
//        return instance.createConnection();
//    }
//}
