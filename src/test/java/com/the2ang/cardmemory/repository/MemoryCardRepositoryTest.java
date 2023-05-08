package com.the2ang.cardmemory.repository;


import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.CardSearchCondition;
import io.swagger.models.auth.In;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
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


    @Test
    @DisplayName("No-Offset 방식을 사용하면 LastStore값 -1 부터 page size 만큼 가져오기")
    void sliceSearchTest() {

        //given
        Slice<MemoryCard> memoryCards
                = memoryCardRepository.searchBySlice(10L, new CardSearchCondition(), PageRequest.ofSize(6));

        //when
        Integer first = memoryCards.getContent().get(0).getId();
        Integer last = memoryCards.getContent().get(5).getId();

        // then
        Assertions.assertThat(first).isEqualTo(7);
        Assertions.assertThat(last).isEqualTo(2);

    }

    @Test
    @DisplayName("마지막 페이지에서는 isLast가 true, 마지막이 아니면 isLast가 false")
    void checkLast() {
        //given
        Slice<MemoryCard> getLastPage
                = memoryCardRepository.searchBySlice(10L, new CardSearchCondition(), PageRequest.ofSize(9));

        Slice<MemoryCard> getMiddlePage
                = memoryCardRepository.searchBySlice(10L, new CardSearchCondition(), PageRequest.ofSize(4));

        //when
        boolean isLastPage = getLastPage.isLast();
        boolean isNotLastPage = getMiddlePage.isLast();

        Assertions.assertThat(isLastPage).isTrue();
        Assertions.assertThat(isNotLastPage).isFalse();

    }

    @Test
    @DisplayName("카드 목록 페이징 처리로 가져오기")
    void testCardListPage() {

        CardSearchCondition condition = new CardSearchCondition();
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<MemoryCard> result = memoryCardRepository.searchMemoryCardPage(condition, pageRequest);

        Assertions.assertThat(result.getSize()).isEqualTo(3);

    }


}
