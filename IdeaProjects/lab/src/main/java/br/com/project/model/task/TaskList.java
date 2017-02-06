package br.com.project.model.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 04/02/17.
 */
public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }
}
