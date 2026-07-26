package com.demo.first.app.service;


import com.demo.first.app.control.UserController;
import com.demo.first.app.exceptions.UserNotFoundException;
import com.demo.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.logging.Logger;

@Service
public class UserService {

    private Map<Integer, User> userDb=new HashMap<>();

    //Logging by using SLF4J
    private final Logger logger= LoggerFactory.getLogger(UserController.class);



    public User createUser(User user) {
        logger.info("Creating User... INFO");
        logger.debug("Creating User... DEBUG");
        logger.trace("Creating User... Trace");
        logger.error("Creating User... Error");
        logger.warn("Creating User... WARN");
        System.out.println(user.getEmail());
       // System.out.println(user.getId());
        //userDb.put(user.getId(), user);
        userDb.putIfAbsent(user.getId(), user);
        //return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return user;
    }

    public User UpdateUser(User user) {
        if(!userDb.containsKey(user.getId())){
            // return ResponseEntity.notFound().build();
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //return null;
//            throw new IllegalArgumentException("user with ID" + user.getId() + "user does not exist");
            logger.error("Error When finding user with id {} ", user.getId());
              throw new UserNotFoundException("User with ID " + user.getId() +"user does not exist");

        }


        userDb.put(user.getId(), user);
        return user;
        //return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    public boolean DeletedUser(int id) {
        if(!userDb.containsKey(id))
            // return ResponseEntity.notFound().build();
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //return false;
            throw new IllegalArgumentException("user with ID" + id + "user does not exist");

        userDb.remove(id);
        // return ResponseEntity.ok("User Deleted");
       // return ResponseEntity.noContent().build();
        return true;
    }

    public List<User> getAllUsers() {

        if(userDb.isEmpty())
            throw new NullPointerException("No users found in the database");

        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {

        return userDb.get(id);
    }

    public List<User> SearchUser(String name, String email) {
       // System.out.println(name);
       // List<User> users=userDb.values().stream()
        return userDb.values().stream()
                .filter(u->u.getName().equalsIgnoreCase(name))
                .filter(u->u.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
