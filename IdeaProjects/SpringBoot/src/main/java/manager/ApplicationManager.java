package manager;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import task.Task;
import task.TaskFactory;
import repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gersonsales on 02/02/17.
 */
@SpringBootApplication
public class ApplicationManager{

//    @Autowired
//    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationManager.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        List<Task> tasks = new LinkedList<>();
//        Task learSpring = TaskFactory.createRealTask("Learn", "Spring", "WORK", "HIGH");
//        tasks.add(learSpring);
//
////        taskRepository.save(tasks);
//
//    }
}
