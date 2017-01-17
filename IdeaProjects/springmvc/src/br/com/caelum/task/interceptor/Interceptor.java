package br.com.caelum.task.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gersonsales on 13/01/17.
 */
public class Interceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{
        String uri = request.getRequestURI();

        if (request.getSession().getAttribute("loggedUser") != null) {
            if (uri.endsWith("signInForm")) {
                response.sendRedirect("menu");
                return false;
            }
            return true;
        }

        if (uri.endsWith("signInForm") || uri.endsWith("signIn") || uri.endsWith("resources")) {
            return true;
        }

        response.sendRedirect("signInForm");
        return false;
    }
}
