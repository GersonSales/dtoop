package br.com.project.service;

import br.com.project.model.factories.TaskFactory;
import br.com.project.model.task.*;
import br.com.project.repository.TaskBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        if (!taskBankRepository.findAll().contains(taskBank)) {
            taskBankRepository.save(taskBank);
        }

    }

    public TaskBank findByName(String bankName) {
        return taskBankRepository.findByName(bankName);
    }


    public List<RealTask> getAllTasks() {
        List<RealTask> allTasks = new ArrayList<>();
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

    public List<String> getBankNames() {
        List<TaskBank> taskBankList = taskBankRepository.findAll();
        List<String> bankNames = taskBankList.stream().map(TaskBank::getName).collect(Collectors.toList());
        Collections.sort(bankNames);


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


    public List<RealTask> getTasksByBank(String bankName) {
        TaskBank taskBank = taskBankRepository.findByName(bankName);
        return taskBank.getAllTasks();
    }

    public List<RealTask> getTasksByCategory(String category) {
        List<RealTask> result = new ArrayList<>();
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

    public List<String> getCategories() {
        List<String> bankNames = categoryList.stream().collect(Collectors.toList());
        Collections.sort(bankNames);
        return bankNames;
    }

    public List<Priority> getPriorities() {
        return Arrays.asList(Priority.values());
    }

    public List<RealTask> getTasksByPriority(String priority) {
        List<RealTask> result = new ArrayList<>();
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

    public void addCSVSubTask(Long taskId, String subtask) {
//        getTaskById(taskId).addAllSubTask(TaskFactory.getSubTaskList(subtask));
//        taskBankRepository.save(new RealTask());
    }

    public void addTaskWithSubTask(String bankName, RealTask task, String subtask) {
        TaskBank taskBank = findByName(bankName);
        List<SubTask> subTaskList = TaskFactory.getSubTaskList(subtask);
        System.out.println(subtask);
        System.out.println(subTaskList);
        task.addAllSubTask(subTaskList);
        taskBank.addTask(task);
        taskBankRepository.save(taskBank);
        System.out.println(task);
    }
}
