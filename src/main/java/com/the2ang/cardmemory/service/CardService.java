package com.the2ang.cardmemory.service;

import com.the2ang.cardmemory.dto.MemoryCardDto;
import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import com.the2ang.cardmemory.dto.request.MemoryCardRequest;
import com.the2ang.cardmemory.dto.response.MemoryCardResponse;
import com.the2ang.cardmemory.dto.response.SelectOptionResponse;
import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.CardSearchCondition;
import com.the2ang.cardmemory.repository.card.searchCondition.MiddleCategorySearchCondition;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private MiddleCategoryRepository middleCategoryRepository;

    @Autowired
    private MemoryCardRepository memoryCardRepository;

    // 대분류 저장.
    @Transactional
    public MainCategory saveMainCategory(MainCategory mainCategory) {
        return mainCategoryRepository.save(mainCategory);
    }

    // 대분류 삭제
    @Transactional
    public void deleteMainCategory(Integer id) {
        mainCategoryRepository.deleteById(id);
    }

    // 대분류 이름으로 검색
    @Transactional(readOnly = true)
    public List<MainCategory> findMainCategoryByname(String name) {
        return mainCategoryRepository.findByName(name);
    }

    // 중분류 저장
    @Transactional
    public MiddleCategory saveMiddleCategory(MiddleCategory middleCategory) {
        return middleCategoryRepository.save(middleCategory);
    }

    // 중분류 삭제
    @Transactional
    public void deleteMiddleCategory(Integer id) {
        middleCategoryRepository.deleteById(id);
    }

    // 대분류 코드로 중분류 검색하기
    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByMainCategoryId(Integer ref) {
        return middleCategoryRepository.findByMainCategory(ref);
    }

    // 중분류명으로 검색하기
    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByName(String name) {
        return middleCategoryRepository.findByName(name);
    }

    // 카드 문제 중분류 코드로 검색하기
    @Transactional(readOnly = true)
    public List<MemoryCardRequest> findMemoryCardByMiddleCategory(Integer ref) {

        List<MemoryCardRequest> results =
                memoryCardRepository.findByMiddleCategory(ref)
                        .stream()
                        .map(MemoryCardRequest::new).collect(Collectors.toList());

        return results;
        //return memoryCardRepository.findByMiddleCategory(ref);
    }

    // 카드 문제 저장하기
    @Transactional
    public MemoryCard saveMemoryCard(MemoryCardRequest memoryCard) {

        MemoryCard target = memoryCard.toEntity();

        return memoryCardRepository.save(target);
    }

    // 카드 삭제
    @Transactional
    public void deleteMemoryCard(Integer id) {
        memoryCardRepository.deleteById(id);
    }

    // 카드 질문명으로 검색하기
    @Transactional(readOnly = true)
    public List<MemoryCard> findMemoryCardByQuestion_dsl(String question) {
        return memoryCardRepository.findByQuestion_dsl2(question);
    }

    // 중분류 코드로 메모리 카드 가져오기 (Apply Fetch Join)
    @Transactional(readOnly = true)
    public List<MemoryCardRequest> findMemoryCardByMiddleCodeFetchJoin(Integer id) {

        List<MemoryCardRequest> results = memoryCardRepository.findByMiddleCategoryFechJoin(id)
                .stream().map(MemoryCardRequest::new).collect(Collectors.toList());
        return results;

//        List<MemoryCardDto> result = orgList.stream()
//                .map( o -> new MemoryCardDto(o.getId(),
//                        o.getMiddleCategory().toDto(),
//                        o.getQuestionType(), o.getQuestion(),
//                        o.getExplanation(),
//                        o.getNum1(),
//                        o.getNum2(),
//                        o.getNum3(),
//                        o.getNum4(),
//                        o.getRightAnswer(),
//                        o.getRightAnswerNum(),
//                        o.getLearningCount(),
//                        o.getLevel(),
//                        o.getCompleted(),
//                        o.getCreatedAt(),
//                        o.getUpdatedAt()
//                        )).collect(Collectors.toList());

      //  return result;
    }

    // 중분류 코드 목록 패치조인으로 가져오기
    @Transactional(readOnly = true)
    public List<MiddleCategoryDto> findAllMiddleCategoryFetchJoin() {
        List<MiddleCategory> orgList = middleCategoryRepository.findAllMiddleCategoryFetchJoin();

        List<MiddleCategoryDto> result = orgList.stream()
                .map(o -> new MiddleCategoryDto(o.getId(),
                        o.getName(),
                        o.getMainCategory().toDto()
                        )).collect(Collectors.toList());
        return result;
    }

    //TODO 중분류 Select Option 대분류 조건으로 가져오는 CardService
    //중분류 Select Option 목록 대분류 조건으로 가져오기
    @Transactional(readOnly = true)
    public List<SelectOptionResponse> getMiddleCategoryByMainCat(MiddleCategorySearchCondition condition) {
        List<MiddleCategory> orgList
                = middleCategoryRepository.findByMainCategorySearch(condition);

        List<SelectOptionResponse> selectOptionResponses = orgList.stream()
                .map(m -> SelectOptionResponse.builder()
                        .label(m.getName())
                        .value(m.getId())
                        .build()).toList();
        return selectOptionResponses;

    }



    // 메모리 카드 벌크로 저장하기...
    @Transactional
    public List<MemoryCard> saveMemoryCardBulk(List<MemoryCard> saveList) {
        return memoryCardRepository.saveAll(saveList);
    }

    // 대분류 코드 전체 가져오기
    @Transactional(readOnly = true)
    public List<MainCategory> findAllMainCategory() {
        return mainCategoryRepository.findAll();
    }

    //대분류 Select Option 리스트로 가져오기
    @Transactional(readOnly = true)
    public List<SelectOptionResponse> getSelectOptionMainCategory() {

        List<MainCategory> orgList = mainCategoryRepository.findAll();
        List<SelectOptionResponse> selectOptionResponses = orgList.stream().map(
                m -> SelectOptionResponse.builder()
                        .label(m.getName())
                        .value(m.getId())
                        .build()
        ).toList();
        return selectOptionResponses;
    }

    //중분류 Select Option 리스트로 가져오기
    @Transactional(readOnly = true)
    public List<SelectOptionResponse> getSelectOptionMiddleCategory() {
        List<MiddleCategory> orgList = middleCategoryRepository.findAllMiddleCategoryFetchJoin();
        List<SelectOptionResponse> selectOptionResponses = orgList.stream().map(
                m -> SelectOptionResponse.builder()
                        .label(m.getName())
                        .value(m.getId())
                        .build()
        ).toList();
        return selectOptionResponses;
    }



    // 중분류 코드 전체 가져오기
    @Transactional(readOnly = true)
    public List<MiddleCategory> findAllMiddleCategory() {
        return middleCategoryRepository.findAll();
    }

    // 메모리 카드 전체 가져오기
    @Transactional(readOnly = true)
    public List<MemoryCard> findAllMemoryCard() {
        return memoryCardRepository.findAll();
    }

    //카드 Slice로 가져오기
    @Transactional(readOnly = true)
    public Slice<MemoryCard> searchMemoryCardSlicing(Long lastCardId, CardSearchCondition condition, Pageable pageable) {
        return memoryCardRepository.searchBySlice(lastCardId, condition, pageable);
    }

    //카드 목록 Page로 가져오기
    @Transactional(readOnly = true)
    public Page<MemoryCard> searchMemoryCardPageing(CardSearchCondition condition, Pageable pageable) {

        Page<MemoryCard> result = memoryCardRepository.searchMemoryCardPage(condition, pageable);

        return result;
    }

    @Transactional(readOnly = true)
    public MemoryCard getMemoryCardByKey(Integer id) {
        MemoryCard result = memoryCardRepository.findByKey(id);
        return result;
    }

    @Transactional(readOnly = true)
    public MiddleCategory getMiddleCategoryByKey(Integer id) {
        return middleCategoryRepository.getMiddleCategoryByKey(id);
    }

    @Transactional(readOnly = true)
    public MainCategory getMainCategoryByKey(Integer id) {
        return mainCategoryRepository.getMainCategoryByKey(id);
    }


}
