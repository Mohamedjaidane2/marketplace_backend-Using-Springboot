package com.example.marketplace.controller;

import com.example.marketplace.dto.AccountDtos.AccountDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackNewDto;
import com.example.marketplace.dto.FeedBackDtos.FeedBackUpdateDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.IFeedBackServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/feedback")
@RequestMapping("/api/feedback")
@RestController
@RequiredArgsConstructor
public class FeedBackController {
    private final IFeedBackServices feedbackService;

    @PostMapping("/create")
    @ApiOperation(value = "Create feedback")
    public ResponseEntity<SuccessDto> addFeedback(@RequestBody FeedBackNewDto feedBackNewDto) {
        return ResponseEntity.ok(feedbackService.addFeedBack(feedBackNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update feedback")
    public ResponseEntity<SuccessDto> updateFeedback(@RequestBody FeedBackUpdateDto feedBackUpdateDto) {
        return ResponseEntity.ok(feedbackService.updateFeedBack(feedBackUpdateDto));
    }

    @GetMapping("/{feedbackId}")
    @ApiOperation(value = "Get feedback by ID")
    public ResponseEntity<FeedBackDto> getFeedbackById(@PathVariable String feedbackId) {
        FeedBackDto feedBackDto = feedbackService.getFeedBackById(feedbackId);
        return ResponseEntity.ok(feedBackDto);
    }

    @GetMapping("/account")
    @ApiOperation(value = "Get feedback by account")
    public ResponseEntity<FeedBackDto> getFeedbackByAccount(@RequestBody AccountDto accountDto) {
        FeedBackDto feedBackDto = feedbackService.getFeedBackByAccount(accountDto);
        return ResponseEntity.ok(feedBackDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all feedback")
    public ResponseEntity<List<FeedBackDto>> getAllFeedback() {
        List<FeedBackDto> feedbackList = feedbackService.getAllFeedBack();
        return ResponseEntity.ok(feedbackList);
    }

    @DeleteMapping("/delete/{feedbackId}")
    @ApiOperation(value = "Delete feedback by ID")
    public ResponseEntity<SuccessDto> deleteFeedbackById(@PathVariable String feedbackId) {
        return ResponseEntity.ok(feedbackService.deleteFeedBackById(feedbackId));
    }
}
