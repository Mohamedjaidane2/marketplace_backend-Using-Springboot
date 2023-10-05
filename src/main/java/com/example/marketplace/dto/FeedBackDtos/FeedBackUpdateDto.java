package com.example.marketplace.dto.FeedBackDtos;

import com.example.marketplace.Enum.EFeedBack;
import com.example.marketplace.dto.ConsumerDtos.ConsumerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FeedBackUpdateDto {

    private String description;

    private Integer Stars;

    private EFeedBack feedBackStatus;

    private Date creationDate;

    private ConsumerDto consumer;
}
