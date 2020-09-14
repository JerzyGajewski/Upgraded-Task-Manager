package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperations {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tasks?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }

    public static void createTable(String... queries) {
        for (String query : queries){
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }


}
