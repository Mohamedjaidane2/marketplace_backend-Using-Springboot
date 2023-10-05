package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackNewDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IFeedBackServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedBackServices {
    @Override
    public SuccessDto addFeedBack(FeedBackNewDto feedBackNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateFeedBack(FeedBackUpdateDto feedBackUpdateDto) {
        return null;
    }

    @Override
    public FeedBackDto getFeedBackById(String feedBackId) {
        return null;
    }

    @Override
    public FeedBackDto getFeedBackByAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public List<FeedBackDto> getAllFeedBack() {
        return null;
    }

    @Override
    public SuccessDto deleteFeedBackById(String feedBackId) {
        return null;
    }
}
