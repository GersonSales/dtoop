package br.com.caelum.task.controller;

import br.com.caelum.task.logic.Task;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by gersonsales on 11/01/17.
 */
@Controller
public class TaskController {

    @RequestMapping("/unnamedMethod")
    public String unnamedMethod() {
        System.out.println("unnamedMethod");
        return "ok";
    }

    @RequestMapping("newTask")
    public String newTask() {
        return "task/form";
    }

    @RequestMapping("addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("description")) {
            System.out.println("ERROR");
            return "task/form";
        }

        return "task/added-task";
    }

}
