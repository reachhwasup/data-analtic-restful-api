package com.example.dataanalyticrestfulapi.service.serviceImp;

import com.example.dataanalyticrestfulapi.model.Transaction;
import com.example.dataanalyticrestfulapi.repository.TransactionRepository;
import com.example.dataanalyticrestfulapi.service.TransactionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public PageInfo<Transaction> getAllTransactions(int page, int size, int filterID) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(transactionRepository.selectAllTransaction(filterID));
    }

    @Override
    public int createNewTransaction(Transaction transaction) {
        return transactionRepository.createNewTransaction(transaction);
    }

    @Override
    public int updateTransaction(Transaction transaction, int transactionId) {
        return transactionRepository.updateTransaction(transaction,transactionId);
    }

    @Override
    public int deleteTransaction( int transactionId) {
        return transactionRepository.deleteTransaction(transactionId);
    }
}
