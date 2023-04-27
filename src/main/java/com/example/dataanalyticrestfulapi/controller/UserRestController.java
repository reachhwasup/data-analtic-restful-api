package com.example.dataanalyticrestfulapi.controller;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import com.example.dataanalyticrestfulapi.model.response.AccountResponse;
import com.example.dataanalyticrestfulapi.service.UserService;
import com.example.dataanalyticrestfulapi.util.Response;
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

    @GetMapping("/user-accounts")
    public Response<List<UserAccount>> getAllUserAccounts(){
        try{
            List<UserAccount> data= userService.getAllUserAccounts();
            return Response.<List<UserAccount>>ok().setPayload(data).setMessage("Successfully!!");

        }catch (Exception e){
            return Response.<List<UserAccount>>exception().setMessage("Exception failed to retrieved all user accounts");
        }
    }

    @PutMapping("/{id}")
    public Response<User> updateUser(@PathVariable int id, @RequestBody User user){
        try{
                userService.updateUser(user, id);
            return Response.<User>updateSuccess().setPayload(user).setMessage("Successfully to update a user with id ");


        } catch (Exception exception){

            return Response.<User>exception().setSuccess(false).setMessage("Fail to update a user with id "+id);
        }
    }

    @DeleteMapping("/{id}")
    public Response<User> deleteUser(@PathVariable int id){
        try {
                userService.removeUser(id);
                return Response.<User>deleteSuccess().setMessage("Successfully deleted a user with id "+id);

        } catch (Exception e){
            return Response.<User>exception().setMessage("Fail to delete a user with id ");
        }
    }
}
