package com.example.marketplace.dto.TagsDtos;

import com.example.marketplace.entity.SubCategory;
import com.example.marketplace.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.jetbrains.annotations.NotNull;
import springfox.documentation.service.Tags;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TagsDto {

    private int tagId;

    private String tagName;

    private SubCategoryDto subcategory;

    private Date creationDate;

    @Override
    public String toString() {
        return "TagsDto{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", subcategory=" + subcategory +
                ", creationDate=" + creationDate +
                '}';
    }

    public static TagsDto customMapping (@NotNull Tag tag){
        return TagsDto.builder()
                .tagId(tag.getTagId())
                .tagName(tag.getTagName())
                .subcategory(SubCategoryDto.customMapping(tag.getSubcategory()))
                .creationDate(tag.getCreationDate())
                .build();
    }
}
