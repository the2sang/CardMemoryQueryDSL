package com.the2ang.cardmemory.entity.card;

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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_category_id")
    private MainCategory mainCategory;

    @OneToMany(mappedBy = "middleCategory")
    private List<MemoryCard> memoryCardList = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String name;

    @Builder
    public MiddleCategory(Long id, MainCategory mainCategory, String name ) {
        this.id = id;
        this.mainCategory = mainCategory;
        this.name = name;
    }

    public MiddleCategory(Long id) {
        this.id = id;
    }


}
