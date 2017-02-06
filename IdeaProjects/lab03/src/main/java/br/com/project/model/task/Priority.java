package br.com.project.model.task;

/**
 * Created by gersonsales on 04/02/17.
 */
public enum Priority {
    NONE, LOW, MEDIUM, HIGH;

    @Override
    public String toString() {
        switch (this) {
            case NONE: return "No Priority";
            case LOW: return "Low";
            case MEDIUM: return "Medium";
            case HIGH: return "High";
        }

        return super.toString();

    }
}
