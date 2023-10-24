package com.example.marketplace.dto.AccountDtos;

import com.example.marketplace.Enum.ESellerLevel;
import com.example.marketplace.dto.AdvertisementDtos.AdvertisementDto;
import com.example.marketplace.dto.BankDataDtos.BankDataDto;
import com.example.marketplace.dto.DiscountRequestDtos.DiscountRequestDto;
import com.example.marketplace.dto.FavoritesDtos.FavoritesDto;
import com.example.marketplace.dto.InformationDtos.InformationDto;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.SalesDtos.SalesDto;
import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountDto {

    private int accountId;

    private Date creationDate;

    private WalletDto wallet;

    private InformationDto information;

    private List<SalesDto> sales;

    private List<BankDataDto> bankData;

    private List<OrderDto> orders;

    private List<FavoritesDto> favorites;

    private List<DiscountRequestDto> discountRequests;

    private List<AdvertisementDto> advertisements;

    private ESellerLevel sellerLevel;

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountId=" + accountId +
                ", creationDate=" + creationDate +
                ", wallet=" + wallet +
                ", information=" + information +
                ", sales=" + sales +
                ", bankData=" + bankData +
                ", orders=" + orders +
                ", favorites=" + favorites +
                ", discountRequests=" + discountRequests +
                ", advertisements=" + advertisements +
                ", sellerLevel=" + sellerLevel +
                '}';
    }

    public static AccountDto customMapping(Account account){
        return AccountDto.builder()
                .accountId(account.getAccountId())
                .advertisements(AdvertisementDto.customListMapping(account.getAdvertisements()))
                .bankData(BankDataDto.customListMapping(account.getBankData()))
                .creationDate(account.getCreationDate())
                .discountRequests(DiscountRequestDto.customListMapping(account.getDiscountRequests()))
                .favorites(FavoritesDto.customListMapping(account.getFavorites()))
                .information(InformationDto.customMapping(account.getInformation()))
                .orders(OrderDto.customListMapping(account.getOrders()))
                .sales(SalesDto.customListMapping(account.getSales()))
                .sellerLevel(account.getSellerLevel())
                .wallet(WalletDto.customMapping(account.getWallet()))
                .build();
    }
}
