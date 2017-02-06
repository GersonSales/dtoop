package br.com.project.model.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsales on 04/02/17.
 */
public class RealTask extends Task{
    private Category category;
    private Priority priority;
    private List<SubTask> subTaskList;

    public RealTask(String title, String description, Category category, Priority priority) {
        super(title, description);
        this.category = category;
        this.priority = priority;

        this.subTaskList = new ArrayList<>();
    }
}
