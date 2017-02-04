package task;

/**
 * Created by gersonsales on 03/02/17.
 */
public class TaskFactory {
    public static Task createRealTask(String title, String description, String categoryStr, String priorityStr) {
        Category category = Category.valueOf(categoryStr);
        Priority priority = Priority.valueOf(priorityStr);
        RealTask realTask = new RealTask(title, description, category, priority);
        return realTask;
    }

}
