package com.example.marketplace.controller;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.TagsDtos.TagsDto;
import com.example.marketplace.dto.TagsDtos.TagsNewDto;
import com.example.marketplace.dto.TagsDtos.TagsUpdateDto;
import com.example.marketplace.service.ITagServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/tags")
@RequestMapping("/api/tags")
@RestController
@RequiredArgsConstructor
public class TagsController {
    private final ITagServices tagService;

    @PostMapping("/create")
    @ApiOperation(value = "Create tag")
    public ResponseEntity<SuccessDto> createTag(@RequestBody TagsNewDto tagsNewDto) {
        return ResponseEntity.ok(tagService.createTag(tagsNewDto));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update tag")
    public ResponseEntity<SuccessDto> updateTag(@RequestBody TagsUpdateDto tagsUpdateDto,Integer tagId) {
        return ResponseEntity.ok(tagService.updateTag(tagsUpdateDto,tagId));
    }

    @GetMapping("/{tagId}")
    @ApiOperation(value = "Get tag by ID")
    public ResponseEntity<TagsDto> getTagById(@PathVariable Integer tagId) {
        TagsDto tagsDto = tagService.getTagById(tagId);
        return ResponseEntity.ok(tagsDto);
    }

    @GetMapping("/name/{tagName}")
    @ApiOperation(value = "Get tag by name")
    public ResponseEntity<TagsDto> getTagByName(@PathVariable String tagName) {
        TagsDto tagsDto = tagService.getTagByName(tagName);
        return ResponseEntity.ok(tagsDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all tags")
    public ResponseEntity<List<TagsDto>> getAllTags() {
        List<TagsDto> tagsList = tagService.getAllTags();
        return ResponseEntity.ok(tagsList);
    }

    @DeleteMapping("/delete/{tagId}")
    @ApiOperation(value = "Delete tag by ID")
    public ResponseEntity<SuccessDto> deleteTagById(@PathVariable Integer tagId) {
        return ResponseEntity.ok(tagService.deleteTagById(tagId));
    }
}
