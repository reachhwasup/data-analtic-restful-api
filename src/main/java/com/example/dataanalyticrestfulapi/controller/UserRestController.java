package com.example.dataanalyticrestfulapi.controller;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import com.example.dataanalyticrestfulapi.model.request.UserRequest;
import com.example.dataanalyticrestfulapi.service.UserService;
import com.example.dataanalyticrestfulapi.util.Response;
import jakarta.validation.Valid;
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
    public Response<List<User>> allUsers(){
        try{
              List<User> response = userService.allUsers();
              return Response.<List<User>>ok().setPayload(response).setMessage("Successfully");
        }catch (Exception e){
            return Response.<List<User>>exception().setMessage("Failed");
        }
    }
    @GetMapping("/{id}")
    public Response<User> findUserById(@PathVariable int id){
        try{
            User response = userService.findUserByID(id);
            if(response!= null){
                return Response.<User>ok().setPayload(response).setSuccess(true).setMessage("Successfully to retrieved ");
            }
            else {
                return  Response.<User>notFound().setMessage("User with id ="+id+"does not exist").setSuccess(false);
            }
        }catch (Exception e){
            return Response.<User>exception().setMessage("Failed to retrieved user with id ="+id);
        }
    }

    @PostMapping("/new-user")
    public Response<User> createNewUser(@Valid @RequestBody UserRequest user) {
        try {
            int userID = userService.createNewUser(user);

            if (userID > 0) {
                User response = new User().setUsername(user.getUsername()).setAddress(user.getAddress()).setGender(user.getGender()).setUserId(userID);
                return Response.<User>createSuccess().setPayload(response).setMessage("Create new user successfully").setSuccess(true);
            } else {
                return Response.<User>badRequest().setMessage("Bad request");
            }
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
            int affectRow = userService.updateUser(user, id);
            if(affectRow>0) {
                User response = new User().setUserId(id).setUsername(user.getUsername()).setGender(user.getGender()).setAddress(user.getAddress());
                return Response.<User>updateSuccess().setPayload(response).setMessage("Successfully to update a user with id ");
            }else {
                return Response.<User>notFound().setMessage("Can not update ").setSuccess(false);
            }

        } catch (Exception exception){

            return Response.<User>exception().setSuccess(false).setMessage("Fail to update a user with id ");
        }
    }

    @DeleteMapping("/{id}")
    public Response<User> deleteUser(@PathVariable int id){
        try {
            int affectRow = userService.removeUser(id);
                if(affectRow >0) {
                    return Response.<User>deleteSuccess().setMessage("Deleted user successfully ");
                }else {
                    return Response.<User>notFound().setMessage("ID  not found can not delete!!!");
                }
        } catch (Exception e){
            return Response.<User>exception().setMessage("Fail to delete a user with id ").setSuccess(false);
        }
    }
}
