package com.demo.first.app.exceptions;

import com.demo.first.app.control.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice   //for centralised exception calling it
@RestControllerAdvice  //for centralised exception handling call it as modified it for json handling

public class GlobalExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);


    //Exception handling method
    @ExceptionHandler({UserNotFoundException.class,IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String,Object>> HandleIllegalArgumentException(Exception exception){
        logger.error("ERROR when finding user: ",exception);
        Map<String,Object>errorResponse=new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status",HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error","Bad Request");
        errorResponse.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String,Object>> HandleMethodNotSupported(Exception exception){
        Map<String,Object>errorResponse=new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status",HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error","Method not allowed on this endpoint");
        errorResponse.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}

/*

{
    "timestamp": "2026-07-11T21:53:59.610Z",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/user"
}

*/
