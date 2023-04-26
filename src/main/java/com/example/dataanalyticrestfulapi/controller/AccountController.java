package com.example.dataanalyticrestfulapi.controller;

import com.example.dataanalyticrestfulapi.model.Account;
import com.example.dataanalyticrestfulapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/all-accounts")
    public ResponseEntity<?> getAllAccounts(){
        try{
            List<Account> allAccount = accountService.getAllAccounts();
            HashMap<String,Object> response = new HashMap<>();
            response.put("payload",allAccount);
            response.put("message","Successfully retrieve all accounts info !");
            response.put("status", HttpStatus.OK);

            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            System.out.println("Something wrong :"+e.getMessage());
            return ResponseEntity.ok().body("Failed to retrieved to thr account");
        }

    }
}
