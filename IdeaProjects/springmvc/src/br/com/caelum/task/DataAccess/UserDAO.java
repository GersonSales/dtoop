package br.com.caelum.task.DataAccess;

import br.com.caelum.task.user.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gersonsales on 13/01/17.
 */
public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    private Connection getConnection() {
        return connection;
    }

    public boolean userExists(User user) {
        try {
            String sqlCommand = "SELECT * FROM users WHERE login=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            statement.setString(1, user.getLogin());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                if (resultSet.getString("login").equals(user.getLogin())) {
                    return true;
                }
            }

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return false;
    }
}
