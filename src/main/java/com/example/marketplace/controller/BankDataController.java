package com.example.marketplace.controller;

import com.example.marketplace.dto.BankDataDtos.BankDataDto;
import com.example.marketplace.dto.BankDataDtos.BankDataNewDto;
import com.example.marketplace.dto.BankDataDtos.BankDataUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IBankDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/bank-data")
@RequestMapping("/api/bank-data")
@RestController
@RequiredArgsConstructor
public class BankDataController {
    private final IBankDataService bankDataService;

    @PostMapping("/add")
    @ApiOperation(value = "Add bank data")
    public ResponseEntity<SuccessDto> addBankData(@RequestBody BankDataNewDto bankDataNewDto) {
        return ResponseEntity.ok(bankDataService.addBankData(bankDataNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update bank data")
    public ResponseEntity<SuccessDto> updateBankData(@RequestBody BankDataUpdateDto bankDataUpdateDto) {
        return ResponseEntity.ok(bankDataService.updateBankData(bankDataUpdateDto));
    }

    @GetMapping("/{bankDataId}")
    @ApiOperation(value = "Get bank data by ID")
    public ResponseEntity<BankDataDto> getBankDataById(@PathVariable Integer bankDataId) {
        BankDataDto bankDataDto = bankDataService.getBankDataById(bankDataId);
        return ResponseEntity.ok(bankDataDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all bank data")
    public ResponseEntity<List<BankDataDto>> getAllBankData() {
        List<BankDataDto> bankDataList = bankDataService.getAllBankData();
        return ResponseEntity.ok(bankDataList);
    }

    @DeleteMapping("/delete/{bankDataId}")
    @ApiOperation(value = "Delete bank data by ID")
    public ResponseEntity<SuccessDto> deleteBankDataById(@PathVariable Integer bankDataId) {
        return ResponseEntity.ok(bankDataService.deleteBankDataById(bankDataId));
    }
}
