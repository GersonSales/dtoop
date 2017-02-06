package br.com.project.model.task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 04/02/17.
 */
@Entity
public class RealTask extends Task{
    private Category category;
    private Priority priority;

//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<SubTask> subTaskList;

    public RealTask(String title, String description, Category category, Priority priority) {
        super(title, description);
        this.category = category;
        this.priority = priority;

//        this.subTaskList = new ArrayList<>();
    }

    public RealTask() {}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
}
