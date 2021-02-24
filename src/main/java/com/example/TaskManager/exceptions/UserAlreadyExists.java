package com.example.TaskManager.exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(String username){
        super(username + " already exists in the database");
    }
}
