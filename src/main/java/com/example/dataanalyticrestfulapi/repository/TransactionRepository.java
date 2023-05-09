package com.example.dataanalyticrestfulapi.repository;


import com.example.dataanalyticrestfulapi.model.Transaction;
import com.example.dataanalyticrestfulapi.repository.provider.TransactionProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionRepository {
    @Results({
        @Result(property= "senderId",column = "sender_account_id"),
        @Result(property = "receiverId",column = "receiver_account_Id"),
        @Result(property = "transferAt",column = "transfer_at")
    })
    @SelectProvider(type = TransactionProvider.class,method = "getAllTransactionSQL")
    List<Transaction> selectAllTransaction(int filterId);

    @InsertProvider(type = TransactionProvider.class, method = "insertTransactionSQL")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createNewTransaction(Transaction transaction);

    @UpdateProvider(type = TransactionProvider.class, method = "updateTransactionSQL")
    int updateTransaction(Transaction transaction, int transactionId);

    @DeleteProvider(type = TransactionProvider.class, method = "deleteTransactionSQL")
    int deleteTransaction(int transactionId);




}
