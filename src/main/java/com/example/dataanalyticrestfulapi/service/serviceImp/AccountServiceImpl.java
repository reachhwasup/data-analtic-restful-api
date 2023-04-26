package com.example.dataanalyticrestfulapi.service.serviceImp;

import com.example.dataanalyticrestfulapi.model.Account;
import com.example.dataanalyticrestfulapi.repository.AccountRepository;
import com.example.dataanalyticrestfulapi.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }

    @Override
    public Account findByID(int id) {
        return accountRepository.findAccountByID(id);
    }
}
