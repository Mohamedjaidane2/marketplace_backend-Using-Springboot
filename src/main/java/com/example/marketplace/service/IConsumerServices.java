package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.CategoryDto;
import com.example.marketplace.dto.entitiesDto.ConsumerDto;

public interface IConsumerServices {
    SuccessDto Register (ConsumerDto consumerDto);
}
