package ch.cern.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.cern.todo.model.TaskCategories;
//extends jpa repository for CRUD methods
public interface TaskCategoryRepository extends JpaRepository<TaskCategories, Long>{

}
