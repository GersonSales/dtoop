package br.com.project.service;

import br.com.project.model.task.RealTask;
import br.com.project.model.task.Task;
import br.com.project.model.task.TaskBank;
import br.com.project.repository.TaskBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gersonsales on 06/02/17.
 */
@Service
public class TaskBankService {

    @Autowired
    private TaskBankRepository taskBankRepository;

    public void addBank(String bankName) {
        TaskBank taskBank = new TaskBank(bankName);
        taskBankRepository.save(taskBank);
    }

    public TaskBank findByName(String bankName) {
        return taskBankRepository.findByName(bankName);
    }


    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        for (TaskBank taskBank : taskBankRepository.findAll()){
            System.out.println("<-----------" + taskBank + "----------->");
            allTasks.addAll(taskBank.getAllTasks());
        }
        return allTasks;
    }

    public void addTask(String bankName, RealTask task) {
        TaskBank taskBank = findByName(bankName);
        taskBank.addTask(task);
        taskBankRepository.save(taskBank);



    }

    public Set<String> getBankNames() {
        Set<String> bankNames = new HashSet<>();
        for (TaskBank taskBank : taskBankRepository.findAll()) {
            bankNames.add(taskBank.getName());
        }

        return bankNames;
    }

    public Task getTaskById(Long id) {
        Task foundTask = null;
        for (TaskBank taskBank : taskBankRepository.findAll()) {
            foundTask = taskBank.getTaskById(id);
            if (foundTask != null) {
                return foundTask;
            }
        }
        return foundTask;


    }

    public void removeTask(Long id) {
        for (TaskBank taskBank : taskBankRepository.findAll()) {
            taskBank.removeTask(id);
        }

    }





}
