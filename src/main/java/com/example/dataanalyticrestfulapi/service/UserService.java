package com.example.dataanalyticrestfulapi.service;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import com.example.dataanalyticrestfulapi.model.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> allUsers();
    List<User> findUserByName();
    User findUserByID(int id);
    int createNewUser(UserRequest user);
    int updateUser(User user, int id);
    int removeUser(int id);
    List<UserAccount> getAllUserAccounts();

}
