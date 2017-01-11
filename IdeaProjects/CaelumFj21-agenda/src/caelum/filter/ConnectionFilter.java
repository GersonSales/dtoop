package caelum.filter;

import caelum.database.ConnectionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gersonsales on 10/01/17.
 */
@WebFilter("/*")
public class ConnectionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Connection connection = ConnectionFactory.getConnection();
            servletRequest.setAttribute("connection", connection);

            filterChain.doFilter(servletRequest, servletResponse);

            connection.close();
        } catch (SQLException error) {
            throw new ServletException(error);
        }

    }

    @Override
    public void destroy() {

    }
}
