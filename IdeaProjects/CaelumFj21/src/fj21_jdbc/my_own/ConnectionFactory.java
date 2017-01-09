package fj21_jdbc.my_own;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gersonsales on 05/01/17.
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/myDatabase", "root", "rootuser");
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

}
