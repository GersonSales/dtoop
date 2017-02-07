package br.com.project.model.task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 04/02/17.
 */
@Entity
public class RealTask extends Task{
    private String category;
    private Priority priority;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SubTask> subTaskList;

    public RealTask(String title, String description, String category, Priority priority) {
        super(title, description);
        this.category = category;
        this.priority = priority;

        this.subTaskList = new ArrayList<>();
    }

    public RealTask() {
        this.category = "";
        this.priority = Priority.NONE;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task type: Real Task";
    }

    public boolean isThatCategory(String category) {
        return getCategory().toString().equalsIgnoreCase(category);
    }

    public boolean isThatPriority(String priority) {
        return getPriority().toString().equalsIgnoreCase(priority);
    }
}
