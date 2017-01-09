package fj21_jdbc.course;

import java.util.Calendar;

/**
 * Created by gersonsales on 05/01/17.
 */
public class JDBCInsere {

    public static void main(String[] args) {
        Contact newContact =  new Contact("Gerson", "email", "Street", Calendar.getInstance());
        ContactDAO DAO = new ContactDAO();
        DAO.addContact(newContact);
        System.out.println("Finished");

        for (Contact contact: DAO.getContacts()) {
            System.out.println("Name: " + contact.getNome());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Street: " + contact.getEndereco());
            System.out.println("BornDate: " + contact.getDataNascimento().getTime());
            System.out.println();
        }
    }
}
