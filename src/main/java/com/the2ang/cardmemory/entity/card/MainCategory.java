package com.the2ang.cardmemory.entity.card;

import com.the2ang.cardmemory.dto.MainCategoryDto;
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
public class MainCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "mainCategory",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MiddleCategory> middleCategories = new ArrayList<>();

    @Column(length = 100, nullable = false)
    private String name;

    @Builder
    public MainCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MainCategoryDto toDto() {
        return MainCategoryDto.builder()
                .id(id)
                .name(name)
                .build();
    }

    public MainCategory(Integer id) {
        this.id = id;
    }

}
