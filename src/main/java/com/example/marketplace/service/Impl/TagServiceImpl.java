package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.dto.TagsDtos.TagsNewDto;
import com.example.marketplace.dto.TagsDtos.TagsUpdateDto;
import com.example.marketplace.entity.SubCategory;
import com.example.marketplace.entity.Tag;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.ISubCategoryRepository;
import com.example.marketplace.repository.ITagRepository;
import com.example.marketplace.service.ITagServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements ITagServices {
    private final ITagRepository tagRepository;
    private final ISubCategoryRepository subCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public SuccessDto createTag(TagsNewDto tagsNewDto) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(tagsNewDto.getSubcategoryId());

        if (subCategory.isEmpty()) {
            throw new EntityNotFoundException("SubCategory not found", ErrorCodes.SUBCATEGORY_NOT_FOUND);
        }

        String tagName = tagsNewDto.getTagName();

        // Check if the tag name already exists in the database
        Optional<Tag> existingTag = tagRepository.findByTagName(tagName);

        if (existingTag.isPresent()) {
            throw new InvalidOperationException("Tag name already exists", ErrorCodes.TAG_ALREADY_IN_USE);
        }

        Tag tag = Tag.builder()
                .tagName(tagName)
                .subcategory(subCategory.get())
                .build();

        tagRepository.save(tag);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
    }




    @Override
    public SuccessDto updateTag(TagsUpdateDto tagsUpdateDto, Integer tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found", ErrorCodes.TAG_NOT_FOUND));

        Optional<SubCategory> subCategory=subCategoryRepository.findById(tagsUpdateDto.getSubcategoryId());
        modelMapper.map(tagsUpdateDto, tag);
        tag.setSubcategory(subCategory.get());


        tagRepository.save(tag);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_UPDATED)
                .build();
    }

    @Override
    public TagsDto getTagById(Integer tagId) {
        Optional<Tag> tag = tagRepository.findById(tagId);
        if (tag.isEmpty()) {
            throw new EntityNotFoundException("Tag not found", ErrorCodes.TAG_NOT_FOUND);
        }
        return TagsDto.customMapping(tag.get());
    }

    @Override
    public TagsDto getTagByName(String tagName) {
        Optional<Tag> tag = tagRepository.findByTagName(tagName);
        if (tag.isEmpty()) {
            throw new EntityNotFoundException("Tag not found", ErrorCodes.TAG_NOT_FOUND);
        }
        return TagsDto.customMapping(tag.get());
    }

    @Override
    public List<TagsDto> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagsDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto deleteTagById(Integer tagId) {
        Optional<Tag> tag = tagRepository.findById(tagId);
        if (tag.isEmpty()) {
            throw new EntityNotFoundException("Tag not found", ErrorCodes.TAG_NOT_FOUND);
        }
        tagRepository.delete(tag.get());

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_REMOVED)
                .build();
    }
}
