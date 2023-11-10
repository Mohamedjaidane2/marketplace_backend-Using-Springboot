package com.example.marketplace.service;

import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;

import java.util.List;

public interface ITransactionServices {

    SuccessDto createTransaction(TransactionNewDto transactionNewDto);

    TransactionDto getTransactionById(Integer transactionId);

    List<TransactionDto> getTransactionsByWalletID(Integer WalletId);

    List<TransactionDto> getAllTransactions();

    SuccessDto cancelTransaction(Integer transactionId);

}
