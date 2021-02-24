package com.example.TaskManager.Repositories;

import com.example.TaskManager.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {


}
