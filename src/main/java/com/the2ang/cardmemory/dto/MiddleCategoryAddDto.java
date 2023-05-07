package com.the2ang.cardmemory.dto;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MiddleCategoryAddDto {

    private final Integer id;
    private final String name;
    private final String mainCategoryId;

    @Builder
    public MiddleCategoryAddDto(Integer id, String name, String mainCategoryId) {
        this.id = id;
        this.name = name;
        this.mainCategoryId = mainCategoryId;
    }

    public MiddleCategory toEntity() {
        return MiddleCategory.builder()
                .id(id)
                .name(name)
                .mainCategory(new MainCategory(Integer.valueOf(mainCategoryId)))
                .build();
    }

}
