package Dao;

import Entity.User;
import Service.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public static void addNewUser(User user){
    String query = "INSERT INTO user (userName, email, password) VALUES (?,?,?)";
    try(Connection conn = DBOperations.getConnection();
        PreparedStatement statement = conn.prepareStatement(query)){
        statement.setString(1,user.getUserName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getPassword());
        statement.executeUpdate();
    }catch (SQLException e){
        e.printStackTrace();
    }
    }


}