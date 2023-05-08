package com.example.dataanalyticrestfulapi.service;

import com.example.dataanalyticrestfulapi.model.Transaction;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


public interface TransactionService {
    PageInfo<Transaction> getAllTransactions(int page, int size,int filterID);
    int createNewTransaction(Transaction transaction);
    int updateTransaction(Transaction transaction,int transactionId);
    int deleteTransaction(int transactionId);
}
