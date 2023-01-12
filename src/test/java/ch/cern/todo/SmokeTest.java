package ch.cern.todo;

import static org.assertj.core.api.Assertions.assertThat;

import ch.cern.todo.controller.TasksController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private TasksController controller;

    @Test
    public void contextLoads() throws Exception { //check if the context created TasksController
        assertThat(controller).isNotNull();
    }
}
