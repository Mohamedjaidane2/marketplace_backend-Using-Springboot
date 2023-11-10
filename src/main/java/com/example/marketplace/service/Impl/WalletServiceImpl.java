package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;
import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.dto.WalletDtos.WalletNewDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Transaction;
import com.example.marketplace.entity.Wallet;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IWalletRepository;
import com.example.marketplace.service.ITransactionServices;
import com.example.marketplace.service.IWalletServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WalletServiceImpl implements IWalletServices {

    private final IAccountRepository iAccountRepository;
    private final IWalletRepository iWalletRepository;
    private final ITransactionServices iTransactionServices;
    @Override
    public SuccessDto createWallet(@NotNull WalletNewDto walletNewDto) {
        //TODO Throw exeption when account id is duplicated --> throw Already USED


        Account account = iAccountRepository.findById(walletNewDto.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND));

        Optional<Wallet> wallet = iWalletRepository.findByAccount_AccountId(walletNewDto.getAccountId());
        if(wallet.isPresent()){
            throw new InvalidOperationException("Wallet already exist",ErrorCodes.WALLET_ALREADY_IN_USE);
        }

        // Create a new Wallet entity with default balance
        Wallet newwallet = Wallet.builder()
                .account(account)
                .balance(0.00)
                .build();
        // Save the wallet to the database
        iWalletRepository.save(newwallet);

        // Create a SuccessDto with a success message
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public double getWalletBalance(Integer walletId) {
        // Retrieve the Wallet entity or throw an exception if not found
        Wallet wallet = iWalletRepository.findById(walletId)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found", ErrorCodes.WALLET_NOT_FOUND));

        // Get the balance from the Wallet entity and return it
        return wallet.getBalance();
    }

    @Override
    public WalletDto getWalletById(Integer walletId) {
        Wallet wallet = iWalletRepository.findById(walletId)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found", ErrorCodes.WALLET_NOT_FOUND));
        return WalletDto.customMapping(wallet);
    }

    @Override
    public SuccessDto addFundsToWallet(Integer walletId, double amount) {
        if (amount<0){
            throw new InvalidOperationException("amount must be superior then zero",ErrorCodes.TRANSACTION_NOT_VALID);
        }
        Wallet wallet = iWalletRepository.findById(walletId)
                .orElseThrow((() -> new EntityNotFoundException("Wallet not found", ErrorCodes.TRANSACTION_NOT_FOUND)));
        TransactionNewDto transactionNewDto = TransactionNewDto.builder()
                        .amount(amount)
                        .walletId(walletId)
                        .build();
        try {
            iTransactionServices.createTransaction(transactionNewDto);
        } catch (InvalidOperationException e) {
            throw new InvalidOperationException("Transaction Noy valid", ErrorCodes.TRANSACTION_NOT_VALID);
        }
        wallet.setBalance(wallet.getBalance() + amount);
        iWalletRepository.save(wallet);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public SuccessDto withdrawFunds(Integer walletId, double amount) {
        Wallet wallet = iWalletRepository.findById(walletId)
                .orElseThrow((() -> new EntityNotFoundException("Wallett not found", ErrorCodes.TRANSACTION_NOT_FOUND)));
        if(amount>wallet.getBalance()){
            throw new InvalidOperationException("Insuffisant funds",ErrorCodes.TRANSACTION_NOT_VALID);
        }

        TransactionNewDto transactionNewDto = TransactionNewDto.builder()
                .amount(amount)
                .walletId(walletId)
                .current_balance(wallet.getBalance()-amount)
                .balance(wallet.getBalance())
                .action(wallet.getBalance() + "-" + amount )
                .build();
        wallet.setBalance(wallet.getBalance() - amount);
        try {
            iTransactionServices.createTransaction(transactionNewDto);
        } catch (InvalidOperationException e) {
            throw new InvalidOperationException("Transaction Noy valid", ErrorCodes.TRANSACTION_NOT_VALID);
        }
        iWalletRepository.save(wallet);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }
}
