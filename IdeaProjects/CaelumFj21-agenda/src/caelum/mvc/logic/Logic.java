package caelum.mvc.logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gersonsales on 07/01/17.
 */
public interface Logic {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
