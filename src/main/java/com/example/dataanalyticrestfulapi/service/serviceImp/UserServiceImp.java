package com.example.dataanalyticrestfulapi.service.serviceImp;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import com.example.dataanalyticrestfulapi.model.request.UserRequest;
import com.example.dataanalyticrestfulapi.repository.UserRepository;
import com.example.dataanalyticrestfulapi.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PageInfo<User> allUsers(int page,int size, String filterName) {
        //Page helper is here
        PageHelper.startPage(page, size);
        return new PageInfo<>(userRepository.allUser(filterName));
//        return userRepository.allUser();

    }

    @Override
    public List<User> findUserByName() {
        return null;
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.findUserByID(id);
    }



    @Override
    public int createNewUser(UserRequest user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(User user, int id) {
        return userRepository.updateUser(user, id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
