package org.burenkov.task_manager.exception;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String message){
        super("Email %s already exists.".formatted(message));
    }
}
