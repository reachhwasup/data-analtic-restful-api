package com.example.dataanalyticrestfulapi.service;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> allUsers();
    List<User> findUserByName();
    User findUserByID(int id);
    int createNewUser(User user);
    int updateUser(User user);
    int removeUser(int id);
    List<UserAccount> getAllUserAccounts();

}
