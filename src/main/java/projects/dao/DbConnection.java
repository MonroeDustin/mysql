package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String SCHEMA = "projects";
    private static final String USER = "projects";
    private static final String PASSWORD = "projects";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;

    public static Connection getConnection() {
        String url = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, SCHEMA);

        System.out.println("Connecting with URL=" + url);

        try {
            Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Connection successful.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}

