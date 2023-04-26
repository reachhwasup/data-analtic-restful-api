package com.example.dataanalyticrestfulapi.controller;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all-user")
    public List<User> allUsers(){
        return userService.allUsers();
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id){
        return userService.findUserByID(id);
    }

    @PostMapping("/new-user")
    public String createNewUser(@RequestBody User user) {
        try {
            int affectRow = userService.createNewUser(user);
            System.out.println(affectRow);
            if (affectRow > 0) {
                return "Create user successfully!!!";
            } else return "Can not create new user";
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
