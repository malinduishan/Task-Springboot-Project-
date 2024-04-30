package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin(origins = "*")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return  userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return user;
    }

    @PutMapping ("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return  userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return  userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserID/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
       return userService.getUserByUserID(userID);
    }
    @GetMapping("/getUserByUserID/{userID}/{fname}")
    public UserDTO getUserByUserIdAndFname(@PathVariable String userID, @PathVariable String fname){
        System.out.println("User Id "+ userID );
        System.out.println("User Name "+fname);
        return userService.getUserByIdAndFname(userID,fname);
    }


}
