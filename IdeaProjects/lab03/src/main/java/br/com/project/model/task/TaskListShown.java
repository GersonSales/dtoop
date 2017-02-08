package br.com.project.model.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gersonsafj on 08/02/17.
 */
public class TaskListShown implements Iterable {

    private List<RealTask> taskList;

    public TaskListShown() {
        this.taskList = new ArrayList<>();
    }

    public void sortByName() {
        taskList.sort((item1, item2) -> item1.compareTo(item2));
    }

    public void sortByPriority() {
        taskList.sort((item1, item2) -> item2.getPriority().compareTo(item1.getPriority()));
    }


    @Override
    public Iterator iterator() {
        return taskList.iterator();
    }

    public void updateList(List<RealTask> taskList) {
        this.taskList.clear();
        this.taskList.addAll(taskList);
    }

    @Override
    public String toString() {
        return "TaskListShown{" +
                "taskList=" + taskList +
                '}';
    }
}
