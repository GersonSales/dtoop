package caelum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gersonsales on 06/01/17.
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            String database = "myDatabase";
            String url = "jdbc:mysql://localhost/" + database;
            String user = "root";
            String password = "rootuser";

            //Load and register JDBC driver for MySQL.
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }
    }

}
