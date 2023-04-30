package com.the2ang.cardmemory.repository;


import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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
public class MemoryCardRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private MemoryCardRepository memoryCardRepository;

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private MiddleCategoryRepository middleCategoryRepository;

    private MainCategory mainCategory;
    private MiddleCategory middleCategory;
    private MemoryCard memoryCard;
    private

    //@BeforeEach
    void setup() {

//        for (int i =0; i < 5; i++) {
//            memoryCard = memoryCard.builder()
//                    .question("질문-" + String.valueOf(i))
//                    .questionType("MC")
//                    .rightAnswer("정답" + String.valueOf(i))
//                    .middleCategory(new MiddleCategory(1L))
//                    .build();
//            memoryCardRepository.save(memoryCard);
//        }

    }

    @Test
    @DisplayName("중분류 코드별 메모리 카드 리스트 가져오기")
    @Order(1)
    public void findMemoryCardByMiddleCategory() {

        for (int i =0; i < 5; i++) {
            memoryCard = memoryCard.builder()
                    .question("질문-" + String.valueOf(i))
                    .questionType("MC")
                    .rightAnswer("정답" + String.valueOf(i))
                    .middleCategory(new MiddleCategory(1))
                    .build();
            memoryCardRepository.save(memoryCard);
        }

        List<MemoryCard> byName = memoryCardRepository.findByMiddleCategory(1);



        log.info("Memory Card Size:" + byName.size());
    }


}
