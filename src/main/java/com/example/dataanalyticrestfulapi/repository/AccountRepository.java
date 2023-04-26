package com.example.dataanalyticrestfulapi.repository;

import com.example.dataanalyticrestfulapi.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
            @Result(property = "accountType",column = "account_type"),
            @Result(property = "phoneNumber",column = "phone_number")
    })
    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account,int id);
    Account findAccountByID(int id);

}
