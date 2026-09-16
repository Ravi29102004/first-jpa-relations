package com.demo.first.app.control;


import com.demo.first.app.model.User;
import com.demo.first.app.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@EnableJpaRepositories
@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

//    private Map<Integer,User> userDb=new HashMap<>();
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping
   // public ResponseEntity<String> createUser(@RequestBody User user){
    public ResponseEntity<User> createUser(@RequestBody User user){
//        System.out.println(user.getEmail());
//        //userDb.put(user.getId(), user);
//        userDb.putIfAbsent(user.getId(), user);
//        //return ResponseEntity.status(HttpStatus.CREATED).body(user);

        User createdUser=userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

//    @PutMapping
//    public String updateUser(@RequestBody User user){
//        if(userDb.containsKey(user.getId()))
//            userDb.put(user.getId(), user);
//        return "update successful";
//    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
//        if(!userDb.containsKey(user.getId()))
//           // return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        userDb.put(user.getId(), user);
//        //return ResponseEntity.status(HttpStatus.OK).body(user);
        User updated=userService.UpdateUser(user);
        if(updated==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(updated);
    }



    // /user/1 /user/2 /user/3
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable int id){
//        if(!userDb.containsKey(id))
//            return "User not Found";
//        userDb.remove(id);
//        return "user deleted";
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted=userService.DeletedUser(id);
        if(!isDeleted)
            // return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

       // userDb.remove(id);
       // return ResponseEntity.ok("User Deleted");
        return ResponseEntity.noContent().build();

    }


    //for dynamic url especially for two url required then it uses
    //@GetMapping({"/users","/user/{Id}"})

    @GetMapping
    public List<User> getUsers(){
        //return new ArrayList<>(userDb.values());
        return userService.getAllUsers();
    }

    // /user/1, /user/100
    //isme internal servor error aa gaya hai
//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUser(@PathVariable int id){
//        if(!userDb.containsKey(id))
//            // return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.ok(userDb.get(id));
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(
            @PathVariable(value="userId" ,required = false) int id){
//        if(!userDb.containsKey(id))
//            // return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.ok(userDb.get(id));
        User user=userService.getUserById(id);
        if(user==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }

    //Multipathvaribles uses

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(
            @PathVariable("userId") int id,
            @PathVariable int orderId
    ){
//        System.out.println("ORDER ID: "+orderId);
//        if(!userDb.containsKey(id))
//            // return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.ok(userDb.get(id));
        User user=userService.getUserById(id);
        if(user==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }

    //Query Params-->(1)-->Request Params
    //e.g-->/search?name=John
    //Single Request Params
//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUser(@RequestParam(required = false , defaultValue = "John") String name){
//        System.out.println(name);
//        return ResponseEntity.ok(new ArrayList<>(userDb.values()));
//    }


    //Multiple Request Params
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(
            @RequestParam(required = false , defaultValue = "John") String name,
            @RequestParam(required = false , defaultValue = "email") String email

    ){
//        System.out.println(name);
//        List<User> users=userDb.values().stream()
//                .filter(u->u.getName().equalsIgnoreCase(name))
//                .filter(u->u.getEmail().equalsIgnoreCase(email))
//                .toList();
        return ResponseEntity.ok(userService.SearchUser(name,email));
    }


    //RequestHeader Concept Logic Used
    @GetMapping("/Info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent){

        return "User Agent: "+ userAgent;
    }

    @GetMapping("/Info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent
    ){
        return "User Agent: "+ userAgent
                +" :" + id
                +" : "+ name;
    }

    //Exception Handling Method
    //for single parameter user
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String,Object>> HandleIllegalArgumentException(IllegalArgumentException exception){
//        Map<String,Object>errorResponse=new HashMap<>();
//        errorResponse.put("timestamp", LocalDateTime.now());
//        errorResponse.put("status",HttpStatus.BAD_REQUEST.value());
//        errorResponse.put("error","Bad Request");
//        errorResponse.put("message",exception.getMessage());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

    //Multiple Parameter Uses
    //to usme iilegalArgument exception not uses but uses for exception
//    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
//    public ResponseEntity<Map<String,Object>> HandleIllegalArgumentException(Exception exception){
//        Map<String,Object>errorResponse=new HashMap<>();
//        errorResponse.put("timestamp", LocalDateTime.now());
//        errorResponse.put("status",HttpStatus.BAD_REQUEST.value());
//        errorResponse.put("error","Bad Request");
//        errorResponse.put("message",exception.getMessage());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

}

/*

{
    "timestamp": "2026-07-11T21:53:59.610Z",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/user"
}

*/
