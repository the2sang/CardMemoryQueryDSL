package com.the2ang.cardmemory.repository.card.searchCondition;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MiddleCategorySearchCondition {
    private Integer id;
    private String name;
    private String mainCategoryId;
}
