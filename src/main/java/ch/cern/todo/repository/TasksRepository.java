package ch.cern.todo.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.cern.todo.model.Tasks;
//extends jpa repository for CRUD methods
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}

//http://localhost:8080/api/tasks

//{"task_name": "kaczka2",
// "task_description": "jajko",
// "deadline": "2023-01-12 12:00:00",
// "category_name": "ciekawe",
// "category_description": "bardzo ciekawe"
//}