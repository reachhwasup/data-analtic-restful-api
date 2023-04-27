package com.example.dataanalyticrestfulapi.repository;


import com.example.dataanalyticrestfulapi.model.Account;
import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper@Repository
public interface UserRepository {
    @Result(column = "id",property = "userId")
    @Select("select * from users_tb")
    List<User> allUser ();
    List<User> findUserByUsername(String username);
    @Insert("insert into users_tb ( username, gender, address)\n" +
            "values (#{user.username},#{user.gender},#{user.address})")
    int createNewUser(@Param("user") User user);
    int updateUser(User user);

    @Result(column = "id",property = "userId")
    @Select("select  * from users_tb where id=#{id}")
    User findUserByID(int id);
    int removeUser(int id);

    @Results({
            @Result(column = "id",property = "userId"),
            @Result(column = "id",property = "accounts",many = @Many(select = "findAccountByID"))
    })
    @Select("select * from users_tb")
    List<UserAccount> getAllUserAccounts();

    @Results({
            @Result(property = "accountName",column = "account_name"),
            @Result(property = "accountNumber",column = "account_no"),
            @Result(property = "transferLimit",column = "transfer_limit"),
            @Result(property = "accountType",column = "account_type",one = @One(select = "com.example.dataanalyticrestfulapi.repository.AccountRepository.getAccountTypeByID"))
    })
    @Select("select * from useraccount_tb inner join accounts_tb a on a.id = useraccount_tb.account_id\n" +
            "where user_id =1")
    List<Account> findAccountByID(int id);

}
