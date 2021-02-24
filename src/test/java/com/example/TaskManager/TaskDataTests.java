package com.example.TaskManager;


import com.example.TaskManager.Repositories.TaskRepo;
import com.example.TaskManager.Repositories.UserRepo;
import com.example.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase
public class TaskDataTests {


    @Autowired
    private TestEntityManager testEntityManager;


    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired

    private TaskService taskService;
}
