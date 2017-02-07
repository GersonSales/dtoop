package br.com.project.model.task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 05/02/17.
 */
@Entity
public class TaskBank {
    @Id
    @GeneratedValue(generator="STORE_SEQ")
    @SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Task> taskList;



    public TaskBank() {
        this.taskList = new ArrayList<>();
    }

    public TaskBank(String name) {
        this();
        this.name = name;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public Task getTaskById(Long id) {
        for (Task task: taskList) {
            if (task.getId().equals(id)) {
                return task;
            }

        }
        return  null;
    }

    public void updateTask(Task task) {
        Task foundTask = getTaskById(task.getId());
        if (foundTask != null) {
            taskList.remove(foundTask);
            taskList.add(task);
        }
    }



    public List<Task> getAllTasks() {
        return taskList;
    }

    public void removeTask(Long id) {
        Task foundTask = getTaskById(id);
        System.out.println("<-------" + foundTask + "-------->");
        taskList.remove(foundTask);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "TaskBank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
