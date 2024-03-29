package com.example.dataanalyticrestfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int id;
    private int senderId;
    private int receiverId;
    private int amount;
    private String remark;
    private LocalDate transferAt;
}
