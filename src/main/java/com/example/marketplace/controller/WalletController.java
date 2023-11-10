package com.example.marketplace.controller;

import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.dto.WalletDtos.WalletNewDto;
import com.example.marketplace.service.IWalletServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("/wallets")
@RequestMapping("/api/wallets")
@RestController
@RequiredArgsConstructor
public class WalletController {
    private final IWalletServices walletService;

    @PostMapping("/create")
    @ApiOperation("Create a wallet ")
    public ResponseEntity<SuccessDto> createWallet(@RequestBody WalletNewDto walletNewDto) {
        return ResponseEntity.ok(walletService.createWallet(walletNewDto));
    }

    @GetMapping("/balance/{walletId}")
    @ApiOperation("Get the balance by walletId")
    public ResponseEntity<Double> getWalletBalance(@PathVariable Integer walletId) {
        double balance = walletService.getWalletBalance(walletId);
        return ResponseEntity.ok(balance);
    }
    @GetMapping("/wallet/{walletId}")
    @ApiOperation("Get the Wallet by walletId")
    public ResponseEntity<WalletDto> getWalletById(@PathVariable Integer walletId) {
        WalletDto wallet = walletService.getWalletById(walletId);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/add-funds")
    @ApiOperation("Add funds to a wallet")
    public ResponseEntity<SuccessDto> addFundsToWallet(@RequestParam Integer walletId, @RequestParam double amount) {
        return ResponseEntity.ok(walletService.addFundsToWallet(walletId, amount));
    }

    @PostMapping("/withdraw-funds")
    @ApiOperation("Withdraw funds from a wallet")
    public ResponseEntity<SuccessDto> withdrawFunds(@RequestParam Integer walletId, @RequestParam double amount) {
        return ResponseEntity.ok(walletService.withdrawFunds(walletId, amount));
    }
}

