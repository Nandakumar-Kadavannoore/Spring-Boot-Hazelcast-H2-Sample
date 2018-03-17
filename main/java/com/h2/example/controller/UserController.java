package com.h2.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.example.entity.User;
import com.h2.example.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
   @Autowired
   UserService userService;

   @PostMapping
   public ResponseEntity<User> addUser(@RequestBody User user) { 
	return new ResponseEntity<>(userService.addUser(user),
            HttpStatus.CREATED);
   }
   
   @PostMapping("/all")
   public ResponseEntity<List<User>> addListOfUser(@RequestBody List<User> user) { 
	return new ResponseEntity<>(userService.addListOfUser(user),
            HttpStatus.CREATED);   
   }
   
   @GetMapping("/all")
   public ResponseEntity<List<User>> getAllUsers() { 
	return new ResponseEntity<>(userService.getAllUsers(),
            HttpStatus.OK);     
   }
}
