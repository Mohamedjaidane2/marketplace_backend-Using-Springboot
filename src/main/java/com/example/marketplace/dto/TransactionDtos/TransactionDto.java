package com.example.marketplace.dto.TransactionDtos;

import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.Tag;
import com.example.marketplace.entity.Transaction;
import com.example.marketplace.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionDto {
    private Integer transaction_id;

    private Date transaction_date;

    private String action ;

    private Integer walletId;

    private double amount;

    private double balance;

    private double current_balance;

    private boolean is_canceled;

    public static List<TransactionDto> customListMapping(List<Transaction> transactions) {
        if(transactions==null) return null;
        ArrayList<TransactionDto> transactionDtoArrayList = new ArrayList<>();
        for (Transaction transaction : transactions){
            TransactionDto transactionDto = customMapping(transaction);
            transactionDtoArrayList.add(transactionDto);
        }
        return transactionDtoArrayList;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transaction_id=" + transaction_id +
                ", transaction_date=" + transaction_date +
                ", amount=" + amount +
                '}';
    }

    public static TransactionDto customMapping (Transaction transaction){
        return TransactionDto.builder()
                .transaction_id(transaction.getTransaction_id())
                .transaction_date(transaction.getTransaction_date())
                .action(transaction.getAction())
                .walletId(transaction.getWallet().getWallet_id())
                .amount(transaction.getAmount())
                .balance(transaction.getBalance())
                .current_balance(transaction.getCurrent_balance())
                .is_canceled(transaction.is_canceled())
                .build();
    }
}
