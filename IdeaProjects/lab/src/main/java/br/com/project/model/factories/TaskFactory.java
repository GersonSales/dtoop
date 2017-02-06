package br.com.project.model.factories;

import br.com.project.model.task.*;

/**
 * Created by gersonsales on 04/02/17.
 */
public class TaskFactory {

    public static Task createRealTask(String title, String description, String categoryStr, String priorityStr) {
        Category category = Category.valueOf(categoryStr);
        Priority priority = Priority.valueOf(priorityStr);

        Task realTask = new RealTask(title, description, category, priority);

        return realTask;
    }

    public static Task createSubTask(String title, String description) {
        Task subTask = new SubTask(title, description);
        return subTask;
    }
}
