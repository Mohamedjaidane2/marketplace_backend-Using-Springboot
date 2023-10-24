package com.example.marketplace.service;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackNewDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface IFeedBackServices {

    SuccessDto addFeedBack(FeedBackNewDto feedBackNewDto);

    SuccessDto updateFeedBack(FeedBackUpdateDto feedBackUpdateDto );


    FeedBackDto getFeedBackById(String feedBackId);

    FeedBackDto getFeedBackByAccount(AccountDto accountDto);

    List<FeedBackDto> getAllFeedBack();

    SuccessDto deleteFeedBackById(String feedBackId);
}
