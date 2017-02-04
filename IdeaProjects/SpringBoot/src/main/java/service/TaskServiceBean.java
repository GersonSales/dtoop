package service;

import task.Task;
import repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gersonsales on 03/02/17.
 */
@Service
public class TaskServiceBean implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }
}
