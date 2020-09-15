package Dao;

import Entity.Tasks;
import Service.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TasksDao {

    public static void createNewTask() {
        String query = "CREATE TABLE IF NOT EXISTS task(\n" +
                "    id INT AUTO_INCREMENT,\n" +
                "    description TEXT,\n" +
                "    isImportant TEXT NOT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                ")";
        DBOperations.createTable(query);
    }
    public static void addNewTask (Tasks task){
        String query = "INSERT INTO task (description, isImportant) VALUES (?,?)";
        try(Connection conn = DBOperations.getConnection();
            PreparedStatement statement = conn.prepareStatement(query)){
            statement.setString(1, task.getDescription());
            statement.setString(2, String.valueOf(task.getImportant()));
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
