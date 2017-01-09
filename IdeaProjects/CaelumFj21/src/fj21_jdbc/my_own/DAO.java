package fj21_jdbc.my_own;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 05/01/17.
 */
public class DAO {
    private Connection connection;

    public DAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    private Connection getConnection() {
        return connection;
    }

    public void addPerson(Person person) {
        String sqlCommand = "insert into people" +
                "(name, age)" +
                "values (?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());

            statement.execute();
            statement.close();

        }catch (SQLException error) {
            throw new RuntimeException(error);

        }
    }

    public void deletePerson(Person person) {
        String sqlCommand = "delete from people where id=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setLong(1, person.getId());

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);

        }
    }

    public void updatePerson(Person person) {
        String sqlCommand = "update people set name=?, age=? where id=?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setLong(3, person.getId());

            statement.execute();
            statement.close();

        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public List<Person> getPeople() {
        String sqlCommand = "select * from people";
        try {
            List<Person> people = new ArrayList<>();

            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");

                Person person = new Person(name, age);
                person.setId(id);

                people.add(person);
            }

            resultSet.close();
            statement.close();

            return people;

        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
