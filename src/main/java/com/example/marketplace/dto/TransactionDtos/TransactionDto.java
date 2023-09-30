package com.example.marketplace.dto.TransactionDtos;

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

    private WalletDto wallet;

    private Float amount;

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
                ", wallet=" + wallet +
                ", amount=" + amount +
                '}';
    }

    public static TransactionDto customMapping (Transaction transaction){
        return TransactionDto.builder()
                .transaction_id(transaction.getTransaction_id())
                .transaction_date(transaction.getTransaction_date())
                .wallet(WalletDto.customMapping(transaction.getWallet()))
                .amount(transaction.getAmount())
                .build();
    }
}
