package com.the2ang.cardmemory.dto.response;


import com.the2ang.cardmemory.entity.card.MiddleCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MiddleCategoryResponse {
    private Integer id;
    private String name;
    private Integer mainCategoryId;

    public MiddleCategoryResponse(MiddleCategory middleCategory) {
        this.id = middleCategory.getId();
        this.name = middleCategory.getName();
        this.mainCategoryId = middleCategory.getMainCategory().getId();
    }
}
