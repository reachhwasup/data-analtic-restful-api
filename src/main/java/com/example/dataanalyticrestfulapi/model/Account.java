package com.example.dataanalyticrestfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String accountName;
    private String accountNumber;
    private String profile;
    private int pin;
    private String passcode;
    private String phoneNumber;
    private int transferLimit;
    private int accountType;

}
