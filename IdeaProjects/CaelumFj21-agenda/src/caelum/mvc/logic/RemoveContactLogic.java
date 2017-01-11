package caelum.mvc.logic;

import caelum.contact.Contact;
import caelum.database.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.time.LocalTime;

/**
 * Created by gersonsales on 07/01/17.
 */
public class RemoveContactLogic implements Logic {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));

        Contact contact = new Contact();
        contact.setId(id);

        Connection connection = (Connection) request.getAttribute("connection");
        DAO dao = new DAO(connection);

        dao.removeContact(contact);
        System.out.println("Excluding contact...");

        return "mvc?logic=ContactsListLogic";
    }
}
