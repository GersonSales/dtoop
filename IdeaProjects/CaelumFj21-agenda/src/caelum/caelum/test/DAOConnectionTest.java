package caelum.caelum.test;

import caelum.contact.Contact;
import caelum.database.DAO;

/**
 * Created by gersonsales on 06/01/17.
 */
public class DAOConnectionTest {

    public static void main(String[] args) {
        DAO dao = new DAO();

        Contact gerson = new Contact("Gerson", 21, "email");

        dao.addContact(gerson);

        System.out.println("Contact " + gerson.getName() + " saved!");

    }
}
