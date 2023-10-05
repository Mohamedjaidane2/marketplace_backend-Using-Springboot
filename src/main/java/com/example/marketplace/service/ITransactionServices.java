package com.example.marketplace.service;

import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;

import java.util.List;

public interface ITransactionServices {

    SuccessDto createTransaction(TransactionNewDto transactionNewDto);

    TransactionDto getTransactionById(String transactionId);

    List<TransactionDto> getTransactionsByUser(String userId);

    List<TransactionDto> getAllTransactions();

    SuccessDto cancelTransaction(String transactionId);
}
