package br.com.project.model.task;

/**
 * Created by gersonsales on 04/02/17.
 */
public enum Category {
    NONE, WORK, STUDY;


    @Override
    public String toString() {
        switch (this) {
            case NONE: return "No Category";
            case WORK: return "Work";
            case STUDY: return "Study";
        }

        return super.toString();

    }
}
