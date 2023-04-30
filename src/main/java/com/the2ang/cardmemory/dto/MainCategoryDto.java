package com.the2ang.cardmemory.dto;


import com.the2ang.cardmemory.entity.card.MainCategory;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainCategoryDto {

    private Integer id;
    private String name;

    @Builder
    public MainCategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MainCategory toEntity() {
        return MainCategory.builder()
                .id(id)
                .name(name)
                .build();
    }
}
