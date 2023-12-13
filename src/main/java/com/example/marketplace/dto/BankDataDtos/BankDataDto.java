package com.example.marketplace.dto.BankDataDtos;
import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankDataDto {

    private Integer bankData_id;

    private String bankName;

    private String rib;

  //  private AccountDto account;

    @Override
    public String toString() {
        return "BankDataDto{" +
                "bankData_id=" + bankData_id +
                ", bankName='" + bankName + '\'' +
                ", rib='" + rib + '\'' +
                '}';
    }

    public static BankDataDto customMapping (BankData bankData){
        return BankDataDto.builder()
                .bankData_id(bankData.getBankData_id())
                .bankName(bankData.getBankName())
                .rib(bankData.getRib())
                .build();
    }
    public static List<BankDataDto> customListMapping(List<BankData> bankData){
        if (bankData == null) return null;
        ArrayList<BankDataDto> bankDataDtoArrayList = new ArrayList<>();
        for (BankData bankData1 : bankData) {
            BankDataDto bankDataDto = customMapping(bankData1);
            bankDataDtoArrayList.add(bankDataDto);
        }
        return bankDataDtoArrayList;
    }
}
