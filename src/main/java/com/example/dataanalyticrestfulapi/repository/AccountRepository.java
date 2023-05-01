package com.example.dataanalyticrestfulapi.repository;

import com.example.dataanalyticrestfulapi.model.Account;
import com.example.dataanalyticrestfulapi.model.AccountType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountRepository {

    @Select("select * from accounts_tb")
    @Results({
            @Result(property = "passcode",column = "passcode"),
            @Result(property = "accountName",column = "account_name"),
            @Result(property = "accountNumber",column = "account_no"),
            @Result(property = "transferLimit",column = "transfer_limit"),
//            @Result(property = "accountType",column = "account_type"),
            @Result(property = "phoneNumber",column = "phone_number"),
            @Result(column = "account_type",property = "accountType",one = @One(select = "getAccountTypeByID"))
    })
    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account,int id);
    Account findAccountByID(int id);

    @Result(property = "accountName",column = "name")
    @Select("select * from accounttype_tb where id=#{account_type}")
    AccountType getAccountTypeByID(int account_type);

    String getProfile();

}
