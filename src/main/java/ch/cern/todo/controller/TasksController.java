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
