package com.example.marketplace.dto.TagsDtos;

import com.example.marketplace.dto.SubCategoryDtos.SubCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TagsNewDto {

    private String tagName;

    private Integer subcategoryId;
}
