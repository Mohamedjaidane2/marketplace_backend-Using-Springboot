package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;
import com.example.marketplace.service.ITransactionServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionServices {
    @Override
    public SuccessDto createTransaction(TransactionNewDto transactionNewDto) {
        return null;
    }

    @Override
    public TransactionDto getTransactionById(String transactionId) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransactionsByUser(String userId) {
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return null;
    }

    @Override
    public SuccessDto cancelTransaction(String transactionId) {
        return null;
    }
}
