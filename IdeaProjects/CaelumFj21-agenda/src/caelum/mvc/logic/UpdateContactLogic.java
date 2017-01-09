package caelum.mvc.logic;

import caelum.contact.Contact;
import caelum.database.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LongSummaryStatistics;

/**
 * Created by gersonsales on 07/01/17.
 */

public class UpdateContactLogic implements Logic{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("status").equals("toUpdate")) {
            showUpdatePage(request, response);
        }else
            if (request.getParameter("status").equals("update")) {
                updateContact(request, response);
        }

        return "mvc?logic=ContactsListLogic";

    }

    private void updateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String email = request.getParameter("email");

        Contact contact = new Contact(name, age, email);
        contact.setId(id);
        DAO.updateContact(contact);

    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Contact contact = DAO.searchById(id);

        request.setAttribute("id", id);
        request.setAttribute("name", contact.getName());
        request.setAttribute("age", contact.getAge());
        request.setAttribute("email", contact.getEmail());

        String page = "/WEB-INF/jsp/updateContact.jsp";
        request.getRequestDispatcher(page).forward(request, response);



    }
}
