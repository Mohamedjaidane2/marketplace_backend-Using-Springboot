package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.BankDataDto;
import com.example.marketplace.dto.entitiesDto.FeedBackDto;

import java.util.List;

public interface IFeedBackServices {

    SuccessDto addFeedBack(FeedBackDto feedBackDto);

    SuccessDto updateFeedBack(FeedBackDto feedBackDto );


    FeedBackDto getFeedBackById(String feedBackId);

    FeedBackDto getFeedBackByAccount(AccountDto accountDto);

    List<FeedBackDto> getAllFeedBack();

    SuccessDto deleteFeedBackById(String feedBackId);
}
