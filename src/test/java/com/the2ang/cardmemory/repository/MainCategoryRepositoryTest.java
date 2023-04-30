package com.the2ang.cardmemory.repository;


import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MainCategoryRepositoryTest {


    @PersistenceContext
    EntityManager em;

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    private MainCategory mainCategory;

    @BeforeEach
    void setup() {

        mainCategory = MainCategory.builder()
                .name("리눅스마스터 2급")
                .build();
        mainCategoryRepository.save(mainCategory);
    }

    @Test
    @DisplayName("메인 카테고리 조회 테스트")
    public void findByNameTest() {

        List<MainCategory> byName = mainCategoryRepository.findByName("test2");

        for( MainCategory category : byName) {
            log.info("category: {}", category);
        }

    }
}
