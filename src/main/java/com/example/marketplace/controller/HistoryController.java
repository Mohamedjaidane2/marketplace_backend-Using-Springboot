package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.HistoryDtos.HistoryDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IHistoryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("/history")
@RequestMapping("/api/history")
@RestController
@RequiredArgsConstructor
public class HistoryController {
    private final IHistoryServices historyService;

    @PostMapping("/create")
    @ApiOperation(value = "Create history")
    public ResponseEntity<SuccessDto> addHistory(@RequestBody HistoryDto historyDto) {
        return ResponseEntity.ok(historyService.addHistory(historyDto));
    }

    @GetMapping("/{historyId}")
    @ApiOperation(value = "Get history by ID")
    public ResponseEntity<HistoryDto> getHistoryById(@PathVariable String historyId) {
        HistoryDto history = historyService.getHistoryById(historyId);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get history by account")
    public ResponseEntity<HistoryDto> getHistoryByAccount(@RequestBody AccountDto accountDto) {
        HistoryDto history = historyService.getHistoryByAccount(accountDto);
        return ResponseEntity.ok(history);
    }

    @DeleteMapping("/delete/{historyId}")
    @ApiOperation(value = "Delete history by ID")
    public ResponseEntity<SuccessDto> deleteHistoryById(@PathVariable String historyId) {
        return ResponseEntity.ok(historyService.deleteHistoryById(historyId));
    }
}
