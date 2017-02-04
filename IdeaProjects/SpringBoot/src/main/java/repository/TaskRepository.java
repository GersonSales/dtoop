package repository;

import task.Category;
import task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gersonsales on 03/02/17.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {//CrudRepository<Task, Long>{
    public List<Task> findByCategory(Category category);
}
