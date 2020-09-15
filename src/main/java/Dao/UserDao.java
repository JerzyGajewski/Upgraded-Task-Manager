package Dao;

import Entity.User;
import Service.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDao {

    public static void createNewUser() {
        String query = "CREATE TABLE IF NOT EXISTS user(\n" +
                "    id INT AUTO_INCREMENT,\n" +
                "    userName VARCHAR(50) NOT NULL,\n" +
                "    email VARCHAR(50) UNIQUE NOT NULL,\n" +
                "    password VARCHAR(50) NOT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                ")";
        DBOperations.createTable(query);
    }

    public static void addNewUser(User user) {
        String query = "INSERT INTO user (userName, email, password) VALUES (?,?,?)";
        try (Connection conn = DBOperations.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//bierze usera, którego userName istnieje w bazie danych
    public static User getByUserName(String userName) {
        String query = "SELECT * FROM user WHERE userName = ?";
        List<Map<String, String>> data = DBOperations.getUserData(query, userName);
        if (data != null) {
            Map<String, String> firsUser = data.get(0);
            User user = createUserFromDataMap(firsUser);
            return user;
        }
        return null;
    }

    private static User createUserFromDataMap(Map<String, String> data) {
        String userName = data.get("userName");
        String email = data.get("email");
        String password = data.get("password");
        User user = new User(userName, email, password);
        return user;
    }

}