package com.the2ang.cardmemory.dto;

import com.the2ang.cardmemory.entity.card.MiddleCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MiddleCategoryDto {

    private final Integer id;
    private final String name;
    private final MainCategoryDto mainCategoryDto;

    @Builder
    public MiddleCategoryDto(Integer id, String name, MainCategoryDto mainCategoryDto) {
        this.id = id;
        this.name = name;
        this.mainCategoryDto = mainCategoryDto;
    }

    public MiddleCategory toEntity() {
        return MiddleCategory.builder()
                .id(id)
                .name(name)
                .mainCategory(mainCategoryDto.toEntity())
                .build();
    }

}
