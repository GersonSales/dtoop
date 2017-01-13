package br.com.caelum.task.controller;

import br.com.caelum.task.DataAccess.DAO;
import br.com.caelum.task.logic.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            return "task/form";
        }

        DAO dao = new DAO();
        dao.addTask(task);

        return "task/taskAdded";
    }

    @RequestMapping("tasksList")
    public String taskList(Model model) {
        DAO dao = new DAO();
        model.addAttribute("tasks", dao.getTasks());

        return "task/list";
    }

    @RequestMapping("removeTask")
    public String removeTask(Task task) {
        DAO dao = new DAO();
        dao.removeTask(task);

        return "redirect:tasksList";
    }
    @RequestMapping("showTask")
    public String showTask(Long id, Model model) {
        DAO dao = new DAO();
        model.addAttribute("task", dao.searchById(id));
        return "task/showTask";
    }

    @RequestMapping("updateTask")
    public String updateTask(Task task) {
        DAO dao = new DAO();
        dao.updateTask(task);
        return "redirect:tasksList";
    }

    @RequestMapping("checkTask")
    public void checkTask(Long id, HttpServletResponse response) {
        DAO dao = new DAO();
        dao.checkTask(id);
        response.setStatus(200);
//        model.addAttribute("task", dao.searchById(id));
//        return "task/checkedTask";
    }

}
