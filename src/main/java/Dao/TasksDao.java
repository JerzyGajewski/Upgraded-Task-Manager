package Dao;

import Entity.Tasks;
import Service.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static void addNewTask(Tasks task) {
        String query = "INSERT INTO task (description, isImportant) VALUES (?,?)";
        try (Connection conn = DBOperations.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, task.getDescription());
            statement.setString(2, String.valueOf(task.getImportant()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Tasks> showAllTasks() {
        List<Tasks> tasks = new ArrayList<>();
        String query = "Select * from task";

        List<Map<String, String>> data = DBOperations.getData(query);
        if (data != null) {
            for (Map<String, String> row : data) {
                Tasks task = createTaskFromData(row);
                tasks.add(task);
            }
        }
        return tasks;
    }

    private static Tasks createTaskFromData(Map<String, String> data) {
        String id = data.get("id");
        String description = data.get("description");
        String isImportant = data.get("isImportant");
        Tasks tasks = new Tasks(Integer.parseInt(id), description, isImportant);
        return tasks;
    }
public static void deleteTask(int id){
        String query = "Delete from task where id = ?";
        try (Connection conn = DBOperations.getConnection();
        PreparedStatement statement = conn.prepareStatement(query)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
}
public static void deleteAllTasks(){
        String query = "DELETE FROM task";
        try(Connection conn = DBOperations.getConnection();
        PreparedStatement statement = conn.prepareStatement(query)){
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
}
}
