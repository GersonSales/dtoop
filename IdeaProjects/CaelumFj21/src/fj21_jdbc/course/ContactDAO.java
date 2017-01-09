package fj21_jdbc.course;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by gersonsales on 05/01/17.
 */
public class ContactDAO {
    private Connection connection;

    private Connection getConnection() {
        return connection;
    }

    public ContactDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void addContact(Contact contact) {
        String sql = "insert into contatos " +
                "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, contact.getNome());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getEndereco());
            statement.setDate(4, new Date(contact.getDataNascimento().getTimeInMillis()));
            statement.execute();
            statement.close();

        }catch (SQLException error) {
            throw new RuntimeException(error);

        }

    }

    public List<Contact> getContacts() {

        try {
            List<Contact> contacts = new ArrayList<>();
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM contatos");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Contact contact = new Contact();

//                contact.setId(resultSet.getLong("id"));
                contact.setNome(resultSet.getString("nome"));
                contact.setEmail(resultSet.getString("email"));
                contact.setEndereco(resultSet.getString("endereco"));


                Calendar date = Calendar.getInstance();
                date.setTime(resultSet.getDate("dataNascimento"));
                contact.setDataNascimento(date);

                contacts.add(contact);


            }

            resultSet.close();
            return contacts;
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }

    }


}
