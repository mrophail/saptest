package com.h2rd.refactoring.web;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;

@RestController
@RequestMapping("users")
public class UserController{
    
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

    return ResponseEntity.ok(userService.saveUser(name, email, roles));
    }

    @RequestMapping(value="/{email}/", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable final String email) {
        userService.deleteUser(email);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }


    @RequestMapping(value="/{email}/", method = RequestMethod.GET)
    public ResponseEntity<User> findUser(@PathVariable final String email) {
    	return ResponseEntity.ok(userService.getUser(email));
    }
}
