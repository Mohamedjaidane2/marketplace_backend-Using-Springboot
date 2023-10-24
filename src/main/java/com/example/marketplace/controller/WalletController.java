package com.example.marketplace.controller;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.WalletDtos.WalletDto;
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
    @ApiOperation(value = "Create a wallet for a user")
    public ResponseEntity<SuccessDto> createWallet(@RequestParam String userId) {
        return ResponseEntity.ok(walletService.createWallet(userId));
    }

    @GetMapping("/balance/{userId}")
    @ApiOperation(value = "Get the balance of a user's wallet")
    public ResponseEntity<WalletDto> getWalletBalance(@PathVariable String userId) {
        WalletDto walletDto = walletService.getWalletBalance(userId);
        return ResponseEntity.ok(walletDto);
    }

    @PostMapping("/add-funds")
    @ApiOperation(value = "Add funds to a user's wallet")
    public ResponseEntity<SuccessDto> addFundsToWallet(@RequestParam String userId, @RequestParam double amount) {
        return ResponseEntity.ok(walletService.addFundsToWallet(userId, amount));
    }

    @PostMapping("/make-payment")
    @ApiOperation(value = "Make a payment from a user's wallet")
    public ResponseEntity<SuccessDto> makePayment(@RequestParam String userId, @RequestParam double amount) {
        return ResponseEntity.ok(walletService.makePayment(userId, amount));
    }

    @PostMapping("/withdraw-funds")
    @ApiOperation(value = "Withdraw funds from a user's wallet")
    public ResponseEntity<SuccessDto> withdrawFunds(@RequestParam String userId, @RequestParam double amount) {
        return ResponseEntity.ok(walletService.withdrawFunds(userId, amount));
    }
}
