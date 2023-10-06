package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.User;
import com.example.marketplace.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/account")
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService accountService;

    @PostMapping("/deactivate")
    @ApiOperation(value = "Deactivate account")
    public ResponseEntity<SuccessDto> deactivateAccount(@RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.deactivateAccount(accountDto));
    }

    @GetMapping("/user")
    @ApiOperation(value = "Get account by user")
    public ResponseEntity<AccountDto> getAccountByUser(@RequestBody User user) {
        AccountDto accountDto = accountService.getAccountByUser(user);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/{accountId}")
    @ApiOperation(value = "Get account by ID")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer accountId) {
        AccountDto accountDto = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}
