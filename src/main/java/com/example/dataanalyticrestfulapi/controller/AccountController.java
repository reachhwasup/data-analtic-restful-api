package com.example.dataanalyticrestfulapi.controller;

import com.example.dataanalyticrestfulapi.mapper.AutoAccountMapper;
import com.example.dataanalyticrestfulapi.model.response.AccountResponse;
import com.example.dataanalyticrestfulapi.service.AccountService;
import com.example.dataanalyticrestfulapi.util.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dataanalyticrestfulapi.model.Account;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AutoAccountMapper autoAccountMapper;

    public AccountController(AccountService accountService, AutoAccountMapper autoAccountMapper) {
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }
    @GetMapping("/all-accounts")
    public Response<List<AccountResponse>> getAllAccounts(){
        try{
            List<Account> allAccount=accountService.getAllAccounts();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);
            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("Successfully retrieved all account information");

        }catch (Exception e){
            System.out.println("Something wrong :"+e.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occurs!! Failed to retrieved accounts information");
        }

    }
}
