package br.com.caelum.task.logic;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;


/**
 * Created by gersonsales on 11/01/17.
 */
public class Task {
    private Long id;

    @NotNull(message="{empty.description}")
    @Size(min = 5, max = 300, message = "{short.description}")
    private String description;

    private boolean checked;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar checkDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Calendar getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Calendar checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() {
        return "Task: " + getId();
    }
}
