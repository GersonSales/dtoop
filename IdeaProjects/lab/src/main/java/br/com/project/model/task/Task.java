package br.com.project.model.task;

import java.util.Calendar;

/**
 * Created by gersonsales on 04/02/17.
 */
public abstract class Task {
    private Long id;
    private String title;
    private String description;
    private boolean checked;
    private Calendar creationDate;
    private Calendar checkDate;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
