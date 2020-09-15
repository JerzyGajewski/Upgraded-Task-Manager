package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBOperations {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tasks?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }

    public static void createTable(String... queries) {
        for (String query : queries) {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement(query)) {
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Map<String, String>> getUserData(String query, String... params) {
        try (
                Connection conn = getConnection();
                PreparedStatement statement = conn.prepareStatement(query)
        ) {
            for(int i=0; i< params.length; i++){
                statement.setString(i+1, params[i]);
            }
            ResultSet set = statement.executeQuery();
            List<String> columnKeyNames = getColumnNames(set);

            List<Map<String, String>> data = new ArrayList<>();
            while (set.next()) {
                Map<String, String> row = new HashMap<>();
                for (String key : columnKeyNames) {
                    row.put(key, set.getString(key));
                }
                data.add(row);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> getColumnNames(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();

        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            columnNames.add(name);

        }
        return columnNames;
    }
}

