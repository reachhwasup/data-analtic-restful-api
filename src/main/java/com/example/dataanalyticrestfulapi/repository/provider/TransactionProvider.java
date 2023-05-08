package com.example.dataanalyticrestfulapi.repository.provider;

import com.example.dataanalyticrestfulapi.model.Transaction;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;


public class TransactionProvider {
    public static String getAllTransactionSQL(){
        return new SQL(){{
            SELECT("*");
            FROM("transactions_tb");
        }}.toString();
    }

    public static String insertTransactionSQL(Transaction transaction) {
        return new SQL() {{
            INSERT_INTO("transactions_tb");
            VALUES("sender_account_id", "#{senderId}");
            VALUES("receiver_account_id", "#{receiverId}");
            VALUES("amount", "#{amount}");
            VALUES("remark", "#{remark}");
            VALUES("transfer_at", "#{transferAt}");
        }}.toString();
    }

    public static String updateTransactionSQL(Transaction transaction, int transactionId){
        return new SQL(){{
            UPDATE("transactions_tb");
            SET("sender_account_id = #{transaction.senderId}");
            SET("receiver_account_id = #{transaction.receiverId}");
            SET("amount = #{transaction.amount}");
            SET("transfer_at = #{transaction.transferAt}");
            SET("remark = #{transaction.remark}");
            WHERE("id = #{transactionId}");
        }}.toString();
    }

    public static String deleteTransactionSQL(int transactionId){
        return new SQL(){{
            DELETE_FROM("transactions_tb");
            WHERE("id = #{transactionId}");
        }}.toString();
    }


}
