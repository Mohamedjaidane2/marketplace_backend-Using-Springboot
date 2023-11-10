package com.example.marketplace.controller;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TransactionDtos.TransactionDto;
import com.example.marketplace.dto.TransactionDtos.TransactionNewDto;
import com.example.marketplace.service.ITransactionServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/transactions")
@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final ITransactionServices transactionService;

    @PostMapping("/create")
    @ApiOperation(value = "Create transaction")
    public ResponseEntity<SuccessDto> createTransaction(@RequestBody TransactionNewDto transactionNewDto) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionNewDto));
    }

    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Get transaction by ID")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Integer transactionId) {
        TransactionDto transactionDto = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "Get transactions by user")
    public ResponseEntity<List<TransactionDto>> getTransactionsByWalletID(@PathVariable Integer walletId) {
        List<TransactionDto> transactions = transactionService.getTransactionsByWalletID(walletId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all transactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/cancel/{transactionId}")
    @ApiOperation(value = "Cancel transaction by ID")
    public ResponseEntity<SuccessDto> cancelTransaction(@PathVariable Integer transactionId) {
        return ResponseEntity.ok(transactionService.cancelTransaction(transactionId));
    }
}
