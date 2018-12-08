package database;


import java.sql.*;

public class DBmanager {

    private static DBmanager instance= new DBmanager();
    public static  final String URL="jdbc:mysql://localhost:3306/airline";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private DBmanager() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;

        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    private void closeConnection() {
        try {
            //Step 3: Establish Java MySQL connection
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}

