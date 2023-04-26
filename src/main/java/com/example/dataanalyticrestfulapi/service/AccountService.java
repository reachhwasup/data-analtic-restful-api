package com.example.dataanalyticrestfulapi.service;

import com.example.dataanalyticrestfulapi.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account,int id);
    Account findByID(int id);
}
