package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.dto.TagsDtos.TagsNewDto;
import com.example.marketplace.dto.TagsDtos.TagsUpdateDto;

import java.util.List;

public interface ITagServices {
    SuccessDto createTag(TagsNewDto tagsNewDto);
    SuccessDto updateTag(TagsUpdateDto tagsUpdateDto,Integer tagId);
    TagsDto getTagById(Integer tagId);
    TagsDto getTagByName(String tagName);
    List<TagsDto> getAllTags();
    SuccessDto deleteTagById(Integer tagId);
}
