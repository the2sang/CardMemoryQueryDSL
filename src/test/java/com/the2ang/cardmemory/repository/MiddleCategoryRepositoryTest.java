package com.the2ang.cardmemory.repository;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
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
public class MiddleCategoryRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private MiddleCategoryRepository middleCategoryRepository;

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    private MiddleCategory middleCategory;
    private MainCategory mainCategory;

    @BeforeEach
    void setup() {

        mainCategory = MainCategory.builder()
                .name("test")
                .build();
        mainCategoryRepository.save(mainCategory);

        for (int i =0; i < 4; i++) {
            middleCategory = middleCategory.builder()
                    .name("test-" + String.valueOf(i))
                    .mainCategory(new MainCategory(1L))
                    .build();
            middleCategoryRepository.save(middleCategory);
        }

    }

    @Test
    @DisplayName("대분류 코드로 중분류 코드 리스트 가져오기")
    public void findMiddleCategoryByMainCategory() {

        List<MiddleCategory> byMainCategory = middleCategoryRepository.findByMainCategory(1L);

        log.info("byMainCategory size:" + byMainCategory.size());

    }
}
