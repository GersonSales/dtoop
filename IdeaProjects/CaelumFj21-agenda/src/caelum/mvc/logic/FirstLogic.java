package caelum.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gersonsales on 07/01/17.
 */
public class FirstLogic implements Logic {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Executing the first business logic... ");
        System.out.println("Returning the JSP name page.");
        return "firstLogic.jsp";
    }
}
