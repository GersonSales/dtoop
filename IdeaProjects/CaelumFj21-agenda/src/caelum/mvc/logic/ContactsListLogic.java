package caelum.mvc.logic;

import caelum.contact.Contact;
import caelum.database.ConnectionFactory;
import caelum.database.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

/**
 * Created by gersonsales on 07/01/17.
 */
public class ContactsListLogic implements Logic {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = (Connection) request.getAttribute("connection");
        DAO dao = new DAO(ConnectionFactory.getConnection());

        List<Contact> contacts = dao.getContacts();
        request.setAttribute("contacts", contacts);
        return "/WEB-INF/jsp/contacts.jsp";
    }
}
