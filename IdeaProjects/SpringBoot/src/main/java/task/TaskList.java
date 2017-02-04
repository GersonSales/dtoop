package task;

import java.util.List;

/**
 * Created by gersonsafj on 02/02/17.
 */
public class TaskList {
    private List<Task> taskList;

    public TaskList() {
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }
}
