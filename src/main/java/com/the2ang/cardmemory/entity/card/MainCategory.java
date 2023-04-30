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
public class MainCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "mainCategory")
    private List<MiddleCategory> middleCategories = new ArrayList<>();

    @Column(length = 100, nullable = false)
    private String name;

    @Builder
    public MainCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
