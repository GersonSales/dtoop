package br.com.caelum.task.controller;

import br.com.caelum.task.DataAccess.TaskDAO;
import br.com.caelum.task.logic.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by gersonsales on 11/01/17.
 */
@Controller
public class TaskController {
    private final TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @RequestMapping("/unnamedMethod")
    public String unnamedMethod() {
        System.out.println("unnamedMethod");
        return "ok";
    }

    @RequestMapping("newTask")
    public String newTask() {
        return "task/taskForm";
    }

    @RequestMapping("addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors("description")) {
            return "task/taskForm";
        }

        this.taskDAO.addTask(task);

        return "task/taskAdded";
    }

    @RequestMapping("tasksList")
    public String taskList(Model model) {
        model.addAttribute("tasks", this.taskDAO.getTasks());

        return "task/list";
    }

    @RequestMapping("removeTask")
    public String removeTask(Task task) {
        this.taskDAO.removeTask(task);

        return "redirect:tasksList";
    }
    @RequestMapping("showTask")
    public String showTask(Long id, Model model) {
        model.addAttribute("task", this.taskDAO.searchById(id));
        return "task/showTask";
    }

    @RequestMapping("updateTask")
    public String updateTask(Task task) {
        this.taskDAO.updateTask(task);
        return "redirect:tasksList";
    }

    @RequestMapping("checkTask")
    public void checkTask(Long id, HttpServletResponse response) {
        this.taskDAO.checkTask(id);
        response.setStatus(200);
//        model.addAttribute("task", taskDao.searchById(id));
//        return "task/checkedTask";
    }

}
