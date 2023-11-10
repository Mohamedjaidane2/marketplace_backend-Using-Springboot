package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;
import com.example.marketplace.entity.Transaction;
import com.example.marketplace.entity.Wallet;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.ITransactionRepository;
import com.example.marketplace.repository.IWalletRepository;
import com.example.marketplace.service.ITransactionServices;
import com.example.marketplace.utils.SuccessMessage;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionServices {

    @Autowired
    private ITransactionRepository transactionRepository;
    @Autowired
    private IWalletRepository iWalletRepository;

    @Override
    public SuccessDto createTransaction(TransactionNewDto transactionNewDto) {
        Wallet wallet = iWalletRepository.findById(transactionNewDto.getWalletId())
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found", ErrorCodes.WALLET_NOT_FOUND));

        Transaction transaction = Transaction.builder()
                .transaction_date(new Date())
                .balance(transactionNewDto.getBalance())
                .current_balance(transactionNewDto.getCurrent_balance())
                .wallet(wallet)
                .amount(transactionNewDto.getAmount())
                .action(transactionNewDto.getAction())
                .is_canceled(false)
                .build();


        transactionRepository.save(transaction);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public TransactionDto getTransactionById(Integer transactionId) {
        // Retrieve the Transaction entity by its ID
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found", ErrorCodes.TRANSACTION_NOT_FOUND));
        return TransactionDto.customMapping(transaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByWalletID(Integer WalletId) {
        Wallet wallet = iWalletRepository.findById(WalletId)
                .orElseThrow((() -> new EntityNotFoundException("Transaction not found", ErrorCodes.TRANSACTION_NOT_FOUND)));
        return TransactionDto.customListMapping(wallet.getTransactions());
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto cancelTransaction(Integer transactionId) {
        // Retrieve the Transaction entity by its ID
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found", ErrorCodes.TRANSACTION_NOT_FOUND));

        // Perform the cancellation logic and update the transaction status
        transaction.set_canceled(true);
        transactionRepository.save(transaction);

        return SuccessDto.builder()
                .message(SuccessMessage.STATUS_CHANGED)
                .build();
    }
}