package caelum.filter;

import com.sun.deploy.ui.AppInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by gersonsales on 10/01/17.
 */
@WebFilter("/*")
public class ExecutionTimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long starTime = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - starTime;
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String parameters = servletRequest.getParameter("logic");
        System.out.println("Request time of " + uri + "?logic=" + parameters + " took " + executionTime + "(ms)");


    }

    @Override
    public void destroy() {

    }
}
