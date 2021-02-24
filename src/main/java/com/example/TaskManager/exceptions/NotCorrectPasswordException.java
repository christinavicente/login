package com.example.TaskManager.exceptions;

public class NotCorrectPasswordException extends RuntimeException{
    public NotCorrectPasswordException( String username){
        super("Sorry, the entered password does not match the password for: " +username);
    }
}
