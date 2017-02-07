package br.com.project.service;

import br.com.project.model.task.*;
import br.com.project.repository.TaskBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by gersonsales on 06/02/17.
 */
@Service
public class TaskBankService {

    @Autowired
    private TaskBankRepository taskBankRepository;

    private Set<String> categoryList;

    public TaskBankService() {
        this.categoryList = new HashSet<>();
    }

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
            taskBankRepository.save(taskBank);
        }

    }


    public List<Task> getTasksByBank(String bankName) {
        TaskBank taskBank = taskBankRepository.findByName(bankName);
        return taskBank.getAllTasks();
    }

    public List<Task> getTasksByCategory(String category) {
        List<Task> result = new ArrayList<>();
        for (Task task : getAllTasks()) {
            if (task instanceof RealTask) {
                RealTask realTask = (RealTask)task;
                if (realTask.isThatCategory(category)) {
                    result.add(realTask);
                }
            }
        }

        return result;
    }

    public void addCategory(String category) {
        categoryList.add(category);
    }

    public Set<String> getCategories() {
        return categoryList;
    }

    public List<Priority> getPriorities() {
        return Arrays.asList(Priority.values());
    }

    public List<Task> getTasksByPriority(String priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : getAllTasks()) {
            if (task instanceof RealTask) {
                RealTask realTask = (RealTask)task;
                if (realTask.isThatPriority(priority)) {
                    result.add(realTask);
                }
            }
        }
        return result;
    }
}
