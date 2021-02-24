package com.example.TaskManager.Repositories;

import com.example.TaskManager.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task, Integer> {

}
