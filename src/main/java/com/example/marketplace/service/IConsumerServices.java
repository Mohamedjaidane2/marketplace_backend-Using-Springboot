package com.example.marketplace.service;

import com.example.marketplace.dto.ConsumerDtos.ConsumerNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

public interface IConsumerServices {
    SuccessDto Register (ConsumerNewDto consumerNewDto);
}
