package caelum.mvc.logic;

import caelum.contact.Contact;
import caelum.database.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by gersonsales on 07/01/17.
 */
public class ContactsListLogic implements Logic {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Contact> contacts = DAO.getContacts();
        request.setAttribute("contacts", contacts);
        return "/WEB-INF/jsp/contacts.jsp";
    }
}
