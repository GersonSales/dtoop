package br.com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gersonsales on 03/02/17.
 */
@Controller
public class TaskController {

    @RequestMapping(value = "/", method = RequestMethod.GET) //pagina index - carrega a lista de tarefas em aberto
    public String indexApp(Model model){
        return "index";
    }
}
