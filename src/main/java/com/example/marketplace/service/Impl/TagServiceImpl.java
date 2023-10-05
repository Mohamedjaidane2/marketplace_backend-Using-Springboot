package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.dto.TagsDtos.TagsNewDto;
import com.example.marketplace.dto.TagsDtos.TagsUpdateDto;
import com.example.marketplace.service.ITagServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagServices {
    @Override
    public SuccessDto createTag(TagsNewDto tagsNewDto) {
        return null;
    }

    @Override
    public SuccessDto updateTag(TagsUpdateDto tagsUpdateDto) {
        return null;
    }

    @Override
    public TagsDto getTagById(String tagId) {
        return null;
    }

    @Override
    public TagsDto getTagByName(String tagName) {
        return null;
    }

    @Override
    public List<TagsDto> getAllTags() {
        return null;
    }

    @Override
    public SuccessDto deleteTagById(String tagId) {
        return null;
    }
}
