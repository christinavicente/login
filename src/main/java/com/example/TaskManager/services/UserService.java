package com.example.TaskManager.services;


import com.example.TaskManager.Repositories.UserRepo;
import com.example.TaskManager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Iterable<User> getAllUsers(){ return userRepo.findAll(); }

    public Optional<User> getUserByID(Integer id){
        return userRepo.findById(id);
    }

    public User getUserByName(String name){
        User users=null;
        for(User user:getAllUsers()){
            if (user.getName().equals(name)){
                users=user;
            }
        }
        return users;
    }

    public User addUser(User user){return userRepo.save(user);}

    public void deleteUser(User user){userRepo.delete(user);}
}
