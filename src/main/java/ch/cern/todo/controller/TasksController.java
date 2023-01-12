package ch.cern.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.cern.todo.model.Tasks;
import ch.cern.todo.repository.TasksRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TasksController {

    @Autowired
    TasksRepository tasksRepository;

    @GetMapping("/tasks")
    public ResponseEntity<List<Tasks>> getAllTasks(@RequestParam(required = false) String task_name) {
        try {
            List<Tasks> tasks = new ArrayList<Tasks>();

            tasksRepository.findAll().forEach(tasks::add);

            if (tasks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable("id") long task_id) {
        Optional<Tasks> tasksData = tasksRepository.findById(task_id);

        if (tasksData.isPresent()) {
            return new ResponseEntity<>(tasksData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks) {
        try {
            Tasks _tasks = tasksRepository
                    .save(new Tasks(tasks.getTaskName(), tasks.getTaskDescription(), tasks.getDeadline()));
            return new ResponseEntity<>(_tasks, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
