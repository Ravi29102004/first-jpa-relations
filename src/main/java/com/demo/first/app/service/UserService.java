package com.demo.first.app.service;


import com.demo.first.app.control.UserController;
import com.demo.first.app.exceptions.UserNotFoundException;
import com.demo.first.app.model.User;
import com.demo.first.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.util.logging.Logger;

@Service
public class UserService {

    private final UserRepository userRepository;

   // private Map<Integer, User> userDb=new HashMap<>();




    //Logging by using SLF4J
    private final Logger logger= LoggerFactory.getLogger(UserController.class);


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User createUser(User user) {
        logger.info("Creating User... INFO");
        logger.debug("Creating User... DEBUG");
        logger.trace("Creating User... Trace");
        logger.error("Creating User... Error");
        logger.warn("Creating User... WARN");
        System.out.println(user.getEmail());
       // System.out.println(user.getId());
        //userDb.put(user.getId(), user);
//        userDb.putIfAbsent(user.getId(), user);
        // Jo profile me null aa raha tha to ussi ko hi resolve karne ke liye logic lagaye
        if(user.getProfile()!=null)
            user.getProfile().setUser(user);

        // now post me null nahi aane ke liye logic create kar rahe hai
        if(user.getPosts()!=null)
            user.getPosts().forEach(post -> post.setUser(user));




        return userRepository.save(user);
        //return ResponseEntity.status(HttpStatus.CREATED).body(user);
        //return user;
    }

    public User UpdateUser(User user) {
//        if(!userDb.containsKey(user.getId())){
//            // return ResponseEntity.notFound().build();
//            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            //return null;
////            throw new IllegalArgumentException("user with ID" + user.getId() + "user does not exist");
//            logger.error("Error When finding user with id {} ", user.getId());
//              throw new UserNotFoundException("User with ID " + user.getId() +"user does not exist");
//
//        }

        Optional<User> userOptional=userRepository.findById(user.getId());

        User existing=userOptional.orElseThrow(()->new UserNotFoundException(("User with ID " + user.getId() +"user does not exist")));


//        userDb.put(user.getId(), user);
//        return user;

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return userRepository.save(existing);
        //return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    public boolean DeletedUser(int id) {
//        if(!userDb.containsKey(id))
            // return ResponseEntity.notFound().build();
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //return false;
           // throw new IllegalArgumentException("user with ID" + id + "user does not exist");

//        userDb.remove(id);
        // return ResponseEntity.ok("User Deleted");
       // return ResponseEntity.noContent().build();
       // return true;

        //By using jpa
        if(!userRepository.existsById(id))
            throw new IllegalArgumentException("user with ID" + id + "user does not exist");


        userRepository.deleteById(id);

        return true;


    }

    public List<User> getAllUsers() {
        //By using jpa+s.b.
        List<User> users=userRepository.findAll();

        if(users.isEmpty())
            throw new NullPointerException("No users found in the database");

        return users;

//        if(userDb.isEmpty())
//            throw new NullPointerException("No users found in the database");
//
//        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {

//        return userDb.get(id);
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user with ID" + id + "user does not exist"));
    }

    public List<User> SearchUser(String name, String email) {
       // System.out.println(name);
       // List<User> users=userDb.values().stream()
        //
//        return userDb.values().stream()
//                .filter(u->u.getName().equalsIgnoreCase(name))
//                .filter(u->u.getEmail().equalsIgnoreCase(email))
//                .toList();

        //-----------------------///
        return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);


    }
}
