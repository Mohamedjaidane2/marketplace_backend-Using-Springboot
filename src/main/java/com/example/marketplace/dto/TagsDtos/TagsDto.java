package com.example.marketplace.dto.TagsDtos;

import com.example.marketplace.entity.Tag;
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
public class TagsDto {

    private int tagId;

    private String tagName;

    private Date creationDate;

    @Override
    public String toString() {
        return "TagsDto{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public static TagsDto customMapping (Tag tag){
        return TagsDto.builder()
                .tagId(tag.getTagId())
                .tagName(tag.getTagName())
                .creationDate(tag.getCreationDate())
                .build();
    }
    public static List<TagsDto> customListMapping(List<Tag> tags){
        if (tags == null) return null;
        ArrayList<TagsDto> tagsDtoArrayList = new ArrayList<>();
        for (Tag tag : tags ) {
            TagsDto tagsDto = customMapping(tag);
            tagsDtoArrayList.add(tagsDto);
        }
        return tagsDtoArrayList;
    }
}
