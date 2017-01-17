package br.com.caelum.task.controller;

import br.com.caelum.task.DataAccess.UserDAO;
import br.com.caelum.task.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by gersonsales on 13/01/17.
 */
@Controller
public class SignInController {

    @RequestMapping("signInForm")
    public String signInForm() {
        return "task/signInForm";
    }

    @RequestMapping("signIn")
    public String signIn(User user, HttpSession session) {
        if (new UserDAO().userExists(user)) {
            session.setAttribute("loggedUser", user);
            return "redirect:menu";
        }
        return "redirect:signInForm";
    }

    @RequestMapping("menu")
    public String menu() {
        return "task/menu";
    }

    @RequestMapping("signOut")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:signInForm";
    }
}
