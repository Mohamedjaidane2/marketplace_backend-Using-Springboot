package com.example.marketplace.dto.entitiesDto;

import com.example.marketplace.Enum.EFeedBack;
import com.example.marketplace.entity.Consumer;
import com.example.marketplace.entity.FeedBack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FeedBackDto {

    private Integer id;

    private String description;

    private Integer Stars;

    private EFeedBack feedBackStatus;

    private Date creationDate;

    private ConsumerDto consumer;

    @Override
    public String toString() {
        return "FeedBackDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", Stars=" + Stars +
                ", feedBackStatus=" + feedBackStatus +
                ", creationDate=" + creationDate +
                ", consumer=" + consumer +
                '}';
    }

    public static FeedBackDto customMapping (FeedBack feedBack){
        return FeedBackDto.builder()
                .id(feedBack.getId())
                .description(feedBack.getDescription())
                .Stars(feedBack.getStars())
                .feedBackStatus(feedBack.getFeedBackStatus())
                .creationDate(feedBack.getCreationDate())
                .consumer(ConsumerDto.customMapping(feedBack.getConsumer()))
                .build();
    }

    public static List<FeedBackDto> customListMapping (List<FeedBack> feedBacks){
        if(feedBacks==null) return null;
        ArrayList<FeedBackDto> feedBackDtoArrayList = new ArrayList<>();
        for (FeedBack feedBack : feedBacks){
            FeedBackDto feedBackDto = customMapping(feedBack);
            feedBackDtoArrayList.add(feedBackDto);
        }
        return feedBackDtoArrayList;
    }
}
