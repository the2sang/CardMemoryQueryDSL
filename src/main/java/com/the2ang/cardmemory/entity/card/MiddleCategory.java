package com.the2ang.cardmemory.entity.card;

import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MiddleCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_category_id")
    private MainCategory mainCategory;

    @OneToMany(mappedBy = "middleCategory", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MemoryCard> memoryCardList = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String name;

    @Builder
    public MiddleCategory(Integer id, MainCategory mainCategory, String name) {
        this.id = id;
        this.mainCategory = mainCategory;
        this.name = name;
    }

    public MiddleCategory(Integer id) {
        this.id = id;
    }

    public MiddleCategoryDto toDto() {
        return MiddleCategoryDto.builder()
                .id(id)
                .name(name)
                .mainCategoryDto(mainCategory.toDto())
                .build();
    }


}
