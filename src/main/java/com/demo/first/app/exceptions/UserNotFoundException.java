package com.demo.first.app.exceptions;

public class UserNotFoundException extends RuntimeException{

    //Constructor
    public UserNotFoundException(String message){
        super(message);

    }


}
