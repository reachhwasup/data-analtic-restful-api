package com.example.dataanalyticrestfulapi.repository;


import com.example.dataanalyticrestfulapi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper@Repository
public interface UserRepository {
    @Result(column = "id",property = "userId")
    @Select("select * from users_tb")
    List<User> allUser ();
    List<User> findUserByUsername(String username);
    int createNewUser(User user);
    int updateUser(User user);

    @Result(column = "id",property = "userId")
    @Select("select  * from users_tb where id=#{id}")
    User findUserByID(int id);
    int removeUser(int id);
}
