package projects.dao;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DbConnectionTest {

    @Test
    public void testConnection() {
        // Attempt to establish a connection and verify it is successful
        try (Connection conn = DbConnection.getConnection()) {
            assertNotNull(conn, "Database connection should not be null.");
            assertFalse(conn.isClosed(), "Connection should be open.");
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            fail("SQL exception occurred during database connection: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected error during database connection: " + e.getMessage());
        }
    }
}



