package br.com.project.controller;

import br.com.project.model.task.RealTask;
import br.com.project.service.TaskBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by gersonsales on 04/02/17.
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskBankService taskBankService;


    @RequestMapping(value = "/taskList", method = RequestMethod.GET)
    public String taskList(Model model) {
        model.addAttribute("taskList", taskBankService.getAllTasks());
        return "tasklist";
    }

    @RequestMapping(value = "/newRealTask", method = RequestMethod.GET)
    public String newTask(Model model) {
        Set<String> bankNames = taskBankService.getBankNames();

        model.addAttribute("bankNames", bankNames);
        return "realtaskform";
    }

    @RequestMapping(value = "/addRealTask", method = RequestMethod.POST)
    public String addTask(@ModelAttribute RealTask task, String bankName, Model  model) {
        taskBankService.addTask(bankName, task);

        return "redirect:/task/taskList";
    }

    @RequestMapping(value = "/showRealTask", method = RequestMethod.GET)
    public String showRealTask(Long id, Model model) {
        model.addAttribute("realTask", taskBankService.getTaskById(id));
        return "showrealtask";
    }

    @RequestMapping(value = "/removeRealTask", method = RequestMethod.GET)
    public String removeRealTask(Long id) {
        taskBankService.removeTask(id);
//        taskService.removeTask(id);
        return "redirect:/task/taskList";
    }


    @RequestMapping(value = "/newTaskBank", method = RequestMethod.GET)
    public String newTaskBank() {
        return "taskbankform";
    }

    @RequestMapping(value = "/addTaskBank", method = RequestMethod.POST)
    public String addTaskBank(String bankName) {
        taskBankService.addBank(bankName);
        return "redirect:/task/taskList";

    }


}
