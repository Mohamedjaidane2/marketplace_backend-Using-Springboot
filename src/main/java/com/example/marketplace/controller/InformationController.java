package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.InformationDtos.InformationNewDto;
import com.example.marketplace.dto.InformationDtos.InformationUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IInformationServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/information")
@RequestMapping("/api/information")
@RestController
@RequiredArgsConstructor
public class InformationController {
    private final IInformationServices informationService;

    @PostMapping("/create")
    @ApiOperation(value = "Create information")
    public ResponseEntity<SuccessDto> addInformation(@RequestBody InformationNewDto informationNewDto) {
        return ResponseEntity.ok(informationService.addInformation(informationNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update information")
    public ResponseEntity<SuccessDto> updateInformation(@RequestBody InformationUpdateDto informationUpdateDto) {
        return ResponseEntity.ok(informationService.updateInformation(informationUpdateDto));
    }

    @GetMapping("/{informationId}")
    @ApiOperation(value = "Get information by ID")
    public ResponseEntity<InformationDto> getInformationById(@PathVariable String informationId) {
        InformationDto information = informationService.getInformationById(informationId);
        return ResponseEntity.ok(information);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get information by account")
    public ResponseEntity<InformationDto> getInformationByAccount(@RequestBody AccountDto accountDto) {
        InformationDto information = informationService.getInformationByAccount(accountDto);
        return ResponseEntity.ok(information);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all information")
    public ResponseEntity<List<InformationDto>> getAllInformation() {
        List<InformationDto> informationList = informationService.getAllInformation();
        return ResponseEntity.ok(informationList);
    }

    @DeleteMapping("/delete/{informationId}")
    @ApiOperation(value = "Delete information by ID")
    public ResponseEntity<SuccessDto> deleteInformationById(@PathVariable String informationId) {
        return ResponseEntity.ok(informationService.deleteInformationById(informationId));
    }
}
