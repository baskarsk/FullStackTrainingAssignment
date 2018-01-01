package com.cts.pm.user;

import com.cts.pm.ProjectManagerApplication;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
    	logger.info("====== GET Enter- getAllUser ======");
        List<User> userData = userService.getUserList();
        logger.info("====== GET Exit- getAllUser ======");
        return new ResponseEntity<List<User>>(userData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userid}")
    public ResponseEntity<User> getUser(@PathVariable Integer userid) {
    	logger.info("====== GET Enter- getUserByid  ======:"+userid);
        User userData = userService.getUserById(userid);
        logger.info("====== GET Exit- getUserByid  ======");
        return new ResponseEntity<User>(userData, HttpStatus.OK);
    }
    

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	logger.info("====== POST Enter- CreateUser ======");
        //HttpHeaders headers = new HttpHeaders();
        //headers.add("Access-Control-Expose-Headers", "Authorization");
        User userData = userService.createUser(user);
        logger.info("====== POST Exit - CreateUser ======");
        return new ResponseEntity<User>(userData,  HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        
    	logger.info("====== PUT Enter- updateUser  ======");
		
        User updateUser = userService.updateUser(user, id);
        logger.info("====== PUT Exit- updateUser  ======");
        return new ResponseEntity<User>(updateUser,HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
    	logger.info("====== DELETE Enter- deleteUser  ======"+id);
         userService.deleteUser(id);        
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }


}
