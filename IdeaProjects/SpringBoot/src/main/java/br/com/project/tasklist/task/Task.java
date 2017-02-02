package br.com.project.tasklist.task;


import java.util.Calendar;

/**
 * Created by gersonsafj on 02/02/17.
 */
public abstract class Task {

    private String tittle;
    private String description;
    private boolean checked;

    private Calendar creationDate;
    private Calendar checkDate;


    public Task(String tittle, String description) {
        this.tittle = tittle;
        this.description = description;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Calendar getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Calendar checkDate) {
        this.checkDate = checkDate;
    }

}
