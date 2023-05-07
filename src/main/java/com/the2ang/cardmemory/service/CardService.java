package com.the2ang.cardmemory.service;

import com.the2ang.cardmemory.dto.MemoryCardDto;
import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
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
    public List<MemoryCard> findMemoryCardByMiddleCategory(Integer ref) {
        return memoryCardRepository.findByMiddleCategory(ref);
    }

    // 카드 문제 저장하기
    @Transactional
    public MemoryCard saveMemoryCard(MemoryCard memoryCard) {
        return memoryCardRepository.save(memoryCard);
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
    public List<MemoryCardDto> findMemoryCardByMiddleCodeFetchJoin(Integer id) {

        List<MemoryCard> orgList = memoryCardRepository.findByMiddleCategoryFechJoin(id);

        List<MemoryCardDto> result = orgList.stream()
                .map( o -> new MemoryCardDto(o.getId(),
                        o.getMiddleCategory().toDto(),
                        o.getQuestionType(), o.getQuestion(),
                        o.getExplanation(),
                        o.getNum1(),
                        o.getNum2(),
                        o.getNum3(),
                        o.getNum4(),
                        o.getRightAnswer(),
                        o.getRightAnswerNum(),
                        o.getLearningCount(),
                        o.getLevel(),
                        o.getCompleted())).collect(Collectors.toList());

        return result;
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


}
