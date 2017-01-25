package br.com.caelum.task.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gersonsales on 12/01/17.
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            String dataBase = "myDatabase";
            String url = "jdbc:mysql://localhost/" + dataBase + "?useSSL=false";
            String user = "root";
            String password = "rootuser";

            //Load and register JDBC driver for MySQL.
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        }catch (SQLException error) {
            throw new RuntimeException(error);
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }

    }
}

