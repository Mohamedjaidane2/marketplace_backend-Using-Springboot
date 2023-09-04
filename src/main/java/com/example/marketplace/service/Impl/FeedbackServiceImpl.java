package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.AccountDto;
import com.example.marketplace.dto.entitiesDto.FeedBackDto;
import com.example.marketplace.service.IFeedBackServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedBackServices {
    @Override
    public SuccessDto addFeedBack(FeedBackDto feedBackDto) {
        return null;
    }

    @Override
    public SuccessDto updateFeedBack(FeedBackDto feedBackDto) {
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
