package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.AddressDtos.AddressDto;
import com.example.marketplace.dto.BankDataDtos.BankDataDto;
import com.example.marketplace.dto.BankDataDtos.BankDataNewDto;
import com.example.marketplace.dto.BankDataDtos.BankDataUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.entity.*;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IBankDataRepository;
import com.example.marketplace.service.IBankDataService;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BankDataServiceImpl implements IBankDataService {
    private final IAccountRepository iAccountRepository;
    private final IBankDataRepository iBankDataRepository;

    private final ModelMapper modelMapper;
    @Override
    public SuccessDto addBankData(BankDataNewDto bankDataNewDto) {

        Account account = iAccountRepository.findById(bankDataNewDto.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND));

        BankData bankData = BankData.builder()
                .account(account)
                .bankName(bankDataNewDto.getBankName())
                .rib(bankDataNewDto.getRib())
                .build();
        iBankDataRepository.save(bankData);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }

    @Override
    public SuccessDto updateBankData(BankDataUpdateDto bankDataUpdateDto) {
        BankData bankData = iBankDataRepository.findById(bankDataUpdateDto.getBankDataId())
                .orElseThrow(() -> new EntityNotFoundException("BankData not found", ErrorCodes.BANKDATA_NOT_FOUND));

        modelMapper.map(bankDataUpdateDto, bankData);
        iBankDataRepository.save(bankData);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public BankDataDto getBankDataById(Integer bankDataId) {
        Optional<BankData> bankData = iBankDataRepository.findById(bankDataId);
        if (bankData.isEmpty()) {
            throw new EntityNotFoundException("BankData not found", ErrorCodes.BANKDATA_NOT_FOUND);
        }
        return BankDataDto.customMapping(bankData.get());
    }

    @Override
    public BankDataDto getBankDataByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<BankDataDto> getAllBankData() {
        return iBankDataRepository.findAll()
                .stream()
                .map(BankDataDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteBankDataById(Integer bankDataId) {
        Optional<BankData> bankData = iBankDataRepository.findById(bankDataId);
        if(bankData.isEmpty())
            throw new EntityNotFoundException("BankData not found!",ErrorCodes.BANKDATA_NOT_FOUND);
        iBankDataRepository.delete(bankData.get());
        return SuccessDto
                .builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }
    }

