package caelum.mvc.logic;

import caelum.contact.Contact;
import caelum.database.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gersonsales on 07/01/17.
 */
public class AddContactLogic implements Logic {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String stringAge = request.getParameter("age");
        Integer age = Integer.valueOf(stringAge);
        String email = request.getParameter("email");

        Contact contact = new Contact(name, age, email);

        DAO.addContact(contact);

        return "mvc?logic=ContactsListLogic";
    }
}
