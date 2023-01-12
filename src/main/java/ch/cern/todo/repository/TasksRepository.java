package ch.cern.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.cern.todo.model.Tasks;
//extends jpa repository for CRUD methods
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
