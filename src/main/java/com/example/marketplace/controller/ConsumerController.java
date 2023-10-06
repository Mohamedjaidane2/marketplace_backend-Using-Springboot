package com.example.marketplace.controller;

import com.example.marketplace.dto.ConsumerDtos.ConsumerNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IConsumerServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("/consumer")
@RequestMapping("/api/consumer")
@RestController
@RequiredArgsConstructor
public class ConsumerController {
    private final IConsumerServices consumerService;

    @PostMapping("/register")
    @ApiOperation(value = "Register new consumer")
    public ResponseEntity<SuccessDto> registerConsumer(@RequestBody ConsumerNewDto consumerNewDto) {
        return ResponseEntity.ok(consumerService.Register(consumerNewDto));
    }
}
