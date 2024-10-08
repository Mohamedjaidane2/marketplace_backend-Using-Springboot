package com.example.marketplace.dto.TagsDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TagsUpdateDto {

    private String tagName;

    private String subcategory;

    private Date creationDate;
    private Integer subcategoryId;
}
