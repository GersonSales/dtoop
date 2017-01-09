package caelum.database;

import caelum.contact.Contact;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 06/01/17.
 */
public class DAO {
    private static Connection connection;

    static  {
        connection = ConnectionFactory.getConnection();
    }

    public DAO() {
    }

    public List<Contact> getContactss() {
        return DAO.getContacts();
    }

    private static Connection getConnection() {
        return connection;
    }

    public static void addContact(Contact contact) {
        try {
            @Language("SQL")
            String sqlCommand = "INSERT INTO contacts (name, age, email) VALUES (?, ?, ?)";

            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setString(1, contact.getName());
            statement.setInt(2, contact.getAge());
            statement.setString(3, contact.getEmail());

            statement.execute();
            statement.close();
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public static List<Contact> getContacts() {
        try {
            List<Contact> contacts = new ArrayList<>();

            @Language("SQL")
            String sqlCommand = "SELECT * FROM contacts";

            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                Contact contact = new Contact(name, age, email);
                contact.setId(id);
                contacts.add(contact);
            }

            resultSet.close();
            statement.close();

            return contacts;

        }catch (SQLException error) {
            throw new RuntimeException(error);
        }

    }

    public static void removeContact(Contact contact) {
        try {
            @Language("SQL")
            String sqlCommand = "DELETE FROM contacts WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            statement.setLong(1, contact.getId());

            statement.execute();
            statement.close();



        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public static void updateContact(Contact contact) {
        try {
            @Language("SQL")
            String sqlCommand = "UPDATE contacts SET name=?, age=?, email=? WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);

            statement.setString(1, contact.getName());
            statement.setInt(2, contact.getAge());
            statement.setString(3, contact.getEmail());
            statement.setLong(4, contact.getId());

            statement.execute();
            statement.close();

        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public static Contact searchById(Long id) {
        try {
            @Language("SQL")
            String sqlCommand = "SELECT * FROM contacts WHERE id=?";

            PreparedStatement statement = getConnection().prepareStatement(sqlCommand);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer age = Integer.valueOf(resultSet.getString("age"));
                String email = resultSet.getString("email");

                Contact contact = new Contact(name, age, email);
                contact.setId(id);

                return contact;
            }

            resultSet.close();
            statement.close();

            return new Contact();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}












