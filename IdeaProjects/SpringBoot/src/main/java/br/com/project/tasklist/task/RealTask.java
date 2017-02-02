package br.com.project.tasklist.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsafj on 02/02/17.
 */
public class RealTask extends Task{

    private Long id;
    private Category category;
    private Priority priority;
    private List<SubTask> subTaskList;

    public RealTask(String tittle, String description, Category category, Priority priority) {
        super(tittle, description);
        this.category = category;
        this.priority = priority;
        this.subTaskList = new ArrayList<>();
    }

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




}
