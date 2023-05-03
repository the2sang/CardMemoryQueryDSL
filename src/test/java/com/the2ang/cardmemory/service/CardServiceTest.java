package com.the2ang.cardmemory.service;


import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CardServiceTest {
    @Autowired
    @Qualifier("memoryCardRepository")
    private BaseRepository memoryCardRepository;

    @Autowired
    @Qualifier("mainCategoryRepository")
    private BaseRepository mainCategoryRepository;

    @Autowired
    @Qualifier("middleCategoryRepository")
    private BaseRepository middleCategoryRepository;

    @PersistenceContext
    EntityManager em;

    @Autowired
    private CardService cardService;

    private MainCategory mainCategory;
    private MiddleCategory middleCategory;
    private MemoryCard memoryCard;

//
//    @BeforeEach
//    void setup() {
//        mainCategoryRepository.deleteAll();
//        middleCategoryRepository.deleteAll();
//        memoryCardRepository.deleteAll();
//    }
//
//    @Test
//    @DisplayName("메인 카테고리 저장 테스트")
//    @Order(1)
//    void saveMainCategory() {
//        mainCategory = MainCategory.builder()
//                .name("리눅스마스터 2급")
//                .build();
//        MainCategory saved = cardService.saveMainCategory(mainCategory);
//
//        List<MainCategory> results = cardService.findMainCategoryByname("리눅스마스터 2급");
//
//        Assertions.assertEquals(results.size(), 1);
//        Assertions.assertEquals(results.get(0).getName(), saved.getName());
//
//        cardService.deleteMainCategory(saved.getId());
//
//    }
//
//    @Test
//    @DisplayName("중분류에서 대분류 참조 리스트 가져오기")
//    @Order(2)
//    void deleteMainCategory() {
//
//        mainCategory = MainCategory.builder()
//                .name("리눅스마스터 2급")
//                .build();
//        MainCategory savedMainCategory = cardService.saveMainCategory(mainCategory);
//
//        List<MiddleCategory> savedList = new ArrayList<>();
//        //중분류 5개 생성 대분류 코드 1
//        for (int i =0; i < 4; i++) {
//            middleCategory = middleCategory.builder()
//                    .name("test-" + String.valueOf(i))
//                    .mainCategory(new MainCategory(savedMainCategory.getId()))
//                    .build();
//            savedList.add(middleCategory);
//        }
//
//        List<MiddleCategory> ressult = middleCategoryRepository.saveAll(savedList);
//        Assertions.assertEquals(ressult.size(), 4);
//
//        middleCategoryRepository.deleteAll(savedList);
//        mainCategoryRepository.deleteById(savedMainCategory.getId());
//
//    }
//
//    @Test
//    @DisplayName("중분류에서 대분류 참조 리스트 가져오기")
//    @Order(3)
//    void findMemoryCardByQuestion() {
//
//
//        List<MemoryCard> ressult = saveDefaultMemoryCardData();
//
//        List<MemoryCard> memoryCardList  = cardService.findMemoryCardByMiddleCategory(ressult.get(0).getMiddleCategory().getId());
//
//        log.info("memoryCardList - " + memoryCardList.size());
//
//        Assertions.assertEquals(memoryCardList.size(), 5);
//
//        mainCategoryRepository.deleteAll();
//        middleCategoryRepository.deleteAll();
//        memoryCardRepository.deleteAll();
//
//
//    }
//
//    @Test
//    void searchMemoryCardByQuestion_fetchJoin() {
//
//        List<MemoryCard> defaultMemoryCard = saveDefaultMemoryCardData();
//
//        //질문명으로 검색
//        List<MemoryCard> memoryCardList = cardService.findMemoryCardByQuestion_dsl("질문");
//
//        log.info("size:" + memoryCardList.size());
//    }
//
//
//
//
//
//    private List<MemoryCard> saveDefaultMemoryCardData() {
//
//
//        MiddleCategory savedMiddleCategory = saveDefaultMiddleCategory();
//
//        List<MemoryCard> saveList = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            memoryCard = memoryCard.builder()
//                    .question("질문")
//                    .middleCategory(savedMiddleCategory)
//                    .rightAnswer("정답")
//                    .questionType("MC")
//                    .rightAnswerNum(1)
//                    .level(1)
//                    .build();
//            saveList.add(memoryCard);
//        }
//
//
//        return memoryCardRepository.saveAll(saveList);
//    }
//
//    private MiddleCategory saveDefaultMiddleCategory() {
//        mainCategory = MainCategory.builder()
//                .name("리눅스마스터 2급")
//                .build();
//        MainCategory savedMainCategory = cardService.saveMainCategory(mainCategory);
//
//        //중분류 5개 생성 대분류 코드 1
//        middleCategory = middleCategory.builder()
//                .name("SQL")
//                .mainCategory(new MainCategory(savedMainCategory.getId()))
//                .build();
//
//        return cardService.saveMiddleCategory(middleCategory);
//    }

}
