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
public class AccountNewDto {

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
}
