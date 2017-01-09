package caelum.mvc.servlet;

import caelum.mvc.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gersonsales on 07/01/17.
 */
@WebServlet("/mvc")
public class ServletController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String param = request.getParameter("logic");
        String className = "caelum.mvc.logic." + param;

        try {
            Class clazz = Class.forName(className);

            Logic logic = (Logic) clazz.newInstance();
            String page = logic.execute(request,response);

            request.getRequestDispatcher(page).forward(request, response);

        }catch (Exception error) {
            throw new ServletException(error);
        }
    }
}
