package br.com.caelum.task.DataAccess;

import br.com.caelum.task.logic.Task;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by gersonsales on 12/01/17.
 */
public class DAO {

    private Connection connection;

    public DAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    private Connection getConnection() {
        return connection;
    }


    public void addTask(Task task) {
        try {
            String sqlCommand = "INSERT INTO tasks (description, checked) VALUES (?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            statement.setString(1, task.getDescription());
            statement.setBoolean(2, task.isChecked());

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public List<Task> getTasks() {
        try {
            List<Task> tasks = new ArrayList<>();
            String sqlCommand = "SELECT * FROM tasks";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setDescription(resultSet.getString("description"));
                task.setChecked(resultSet.getBoolean("checked"));
//                task.setCheckDate(resultSet.getDate("checkDate")); TODO
                tasks.add(task);
            }

            resultSet.close();
            statement.close();

            return tasks;
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void removeTask(Task task) {
        try {
            String sqlCommand = "DELETE FROM tasks WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setLong(1, task.getId());

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public Task searchById(Long id) {
        try {
            String sqlCommand = "SELECT * FROM tasks WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            statement.setLong(1,  id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            Task task = new Task();
            task.setId(resultSet.getLong("id"));
            task.setDescription(resultSet.getString("description"));
            task.setChecked(resultSet.getBoolean("checked"));
//            task.setCheckDate(resultSet.getDate("checkDate"));

            resultSet.close();
            statement.close();

            return task;
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void updateTask(Task task) {

        try {
            String sqlCommand = "UPDATE tasks SET description=?, checked=?, checkDate=? WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setString(1, task.getDescription());
            statement.setBoolean(2, task.isChecked());

            statement.setDate(3, null);

            statement.setLong(4, task.getId());


            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }

    }

    public void checkTask(Long taskId) {
        try {
            String sqlCommand = "UPDATE tasks SET checked=? WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setBoolean(1, true);
            statement.setLong(2, taskId);

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
