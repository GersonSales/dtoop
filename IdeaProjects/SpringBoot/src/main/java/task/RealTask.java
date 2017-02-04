package task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gersonsafj on 02/02/17.
 */
@Entity
public class RealTask extends Task{

    @Id
    @GeneratedValue
    private Long id;
    private Category category;
    private Priority priority;
    private List<SubTask> subTaskList;

    public RealTask(String title, String description, Category category, Priority priority) {
        super(title, description);
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
