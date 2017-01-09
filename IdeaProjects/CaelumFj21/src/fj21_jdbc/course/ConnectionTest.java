package fj21_jdbc.course;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gersonsales on 05/01/17.
 */
public class ConnectionTest {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        System.out.println("Connection Opened");
        connection.close();
        System.out.println("Connection Closed");
    }
}
