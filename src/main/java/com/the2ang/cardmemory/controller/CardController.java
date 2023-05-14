package com.the2ang.cardmemory.controller;


import com.the2ang.cardmemory.controller.response.CommonResponse;
import com.the2ang.cardmemory.controller.response.CommonResult;
import com.the2ang.cardmemory.controller.response.ListResult;
import com.the2ang.cardmemory.controller.response.PageResult;
import com.the2ang.cardmemory.dto.*;
import com.the2ang.cardmemory.dto.jwt.TokenInfo;
import com.the2ang.cardmemory.dto.request.MemoryCardPageRequest;
import com.the2ang.cardmemory.dto.request.MemoryCardRequest;
import com.the2ang.cardmemory.dto.response.MemoryCardPageResponse;
import com.the2ang.cardmemory.dto.response.MemoryCardResponse;
import com.the2ang.cardmemory.dto.response.SelectOptionResponse;
import com.the2ang.cardmemory.entity.card.*;
import com.the2ang.cardmemory.repository.card.searchCondition.CardSearchCondition;
import com.the2ang.cardmemory.repository.card.searchCondition.MiddleCategorySearchCondition;
import com.the2ang.cardmemory.service.AccountService;
import com.the2ang.cardmemory.service.CardService;
import com.the2ang.cardmemory.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"1. 플레시 카드 서비스"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {

    private final CardService cardService;
    private final ResponseService responseService;
    private final AccountService accountService;


    @PostMapping("/login")
    public CommonResult login(@RequestBody AccountReqDto account , HttpServletResponse response) {
        String username = account.getNickname();
        String password = account.getPw();
        return responseService.getSingleResult(accountService.login(new LoginReqDto(username, password, ""), response ));
        //return tokenInfo;
    }

    @ApiOperation(value = "대분류 저장", notes = "대분류 저장하기")
    @PostMapping("/mainCategory/new")
    public CommonResult saveMainCategory(@RequestBody @Valid MainCategoryDto request) {

        return responseService.getSingleResult(cardService.saveMainCategory(request.toEntity()));
    }

    @ApiOperation(value = "대분류 업데이트", notes = "대분류 업데이트")
    @PutMapping("/mainCategory/update")
    public MainCategory updateMainCategory(@RequestBody @Valid MainCategoryDto request) {
        return cardService.saveMainCategory(request.toEntity());
    }

    @ApiOperation(value = "대분류 삭제", notes = "대분류 삭제하기")
    @DeleteMapping ("/mainCategory/{id}")
    @CrossOrigin(origins = "*")
    public CommonResult deleteMainCategory(@PathVariable String id) {
        cardService.deleteMainCategory(Integer.valueOf(id));
        return responseService.getSuccessResult();
    }


    @ApiOperation(value = "대분류 삭제", notes = "대분류 삭제하기")
    @PostMapping("/mainCategory/{id}")
    public CommonResult deleteMainCategory_post(@PathVariable String id) {
        cardService.deleteMainCategory(Integer.valueOf(id));
        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "중분류 저장히기")
    @PostMapping("/middleCategory/new")
    public CommonResult saveMiddleCategory(@RequestBody @Valid MiddleCategoryDto request) {
        return responseService.getSingleResult(cardService.saveMiddleCategory(request.toEntity()));
    }

    @ApiOperation(value = "중분류 저장히기 2")
    @PostMapping("/middleCategory/new2")
    public CommonResult saveMiddleCategory2(@RequestBody @Valid MiddleCategoryAddDto request) {

        System.out.println(request.toString());

        return responseService.getSingleResult(cardService.saveMiddleCategory(request.toEntity()));
    }

    @ApiOperation(value = "중분류 업데이트 하기")
    @PutMapping("/middleCategory/update")
    public CommonResult updateMiddleCategory(@RequestBody @Valid MiddleCategoryDto request) {
        return responseService.getSingleResult(cardService.saveMiddleCategory(request.toEntity()));
    }

    @ApiOperation(value = "중분류 삭제", notes = "중분류 삭제하기")
    @DeleteMapping ("/middleCategory/{id}")
    public CommonResult deleteMiddleCategory(@PathVariable String id) {
        cardService.deleteMiddleCategory(Integer.valueOf(id));
        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "메모리 카드 저장하기", notes = "메모리 카드 저장")
    @PostMapping("/memoryCard/new")
    public CommonResult saveMemoryCard(@RequestBody @Valid MemoryCardRequest memoryCard) {
        return responseService.getSingleResult(cardService.saveMemoryCard(memoryCard));
    }

    @ApiOperation(value = "메모리 카드 저장히기 2")
    @PostMapping("/memoryCard/new2")
    public CommonResult saveMemoryCard2(@RequestBody @Valid MemoryCardRequest memoryCard) {

        //System.out.println(request.toString());

        return responseService.getSingleResult(cardService.saveMemoryCard(memoryCard));
    }

    @ApiOperation(value = "메모리 카드 업데이트")
    @PutMapping("/memoryCard/update")
    public CommonResult updateMemoryCard(@RequestBody @Valid MemoryCardRequest memoryCard) {
        return responseService.getSingleResult(cardService.saveMemoryCard(memoryCard));
    }

    @ApiOperation(value = "메모리 카드 삭제", notes = "메모리 카드 삭제하기")
    @DeleteMapping ("/memoryCard/{id}")
    public CommonResult deleteMemoryCard(@PathVariable String id) {
        cardService.deleteMemoryCard(Integer.valueOf(id));
        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "중분류 코드로 메모리 카드 가져오기", notes = "중분류 코드로 메모리 카드 조회")
    @GetMapping("/memoryCard/middlecode")
    public ListResult<MemoryCardRequest> findMamoryCardByMiddleCategoryId(@RequestParam String param) {
        ListResult<MemoryCardRequest> result = responseService.getListResult(cardService.findMemoryCardByMiddleCodeFetchJoin(Integer.valueOf(param)));
       // return responseService.getListResult(jacksonObjectMapper().registerModule(Hibernate5Module())
       //         .writeValueAsString(cardService.findMemoryCardByMiddleCodeFetchJoin(Integer.valueOf(param))));

       return result;
    }

    @ApiOperation(value = "대분류 코드 전체 가져오기", notes = "대분류 코드 모두 읽기")
    @GetMapping("/mainCategory/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public ListResult<MainCategory> getAllMainCategory() {
        return responseService.getListResult(cardService.findAllMainCategory());
    }

    @ApiOperation(value = "중분류 코드 전체 가져오기", notes = "중분류 코드 모두 읽기")
    @GetMapping("/middleCategory/all")
    public ListResult<MiddleCategory> getAllMiddleCategory() {
        return responseService.getListResult(cardService.findAllMiddleCategory());
    }

    @ApiOperation(value = "메모리 카드 전체 가져오기", notes = "메모리 카드 전체 읽기")
    @GetMapping("/memoryCard/all")
    public ListResult<MemoryCard> getAllMemoryCard() {
        return responseService.getListResult(cardService.findAllMemoryCard());
    }

    @ApiOperation(value = "중분류 코드 전체 패치조인으로 가져오기")
    @GetMapping("/middleCategoryFetch/all")
    public ListResult<MiddleCategoryDto> getAllMiddleCategoryFetch() {
        return responseService.getListResult(cardService.findAllMiddleCategoryFetchJoin());
    }

    //벌크로 저장
    @ApiOperation(value = "카드 학습 벌크로 저장하기", notes = "카드 학습 벌크저장")
    @PostMapping("/memorycard/bulksave")
    public CommonResult saveMemoryCardBulk(@RequestBody @Valid List<MemoryCard> bulklist) {
        return responseService.getSingleResult(cardService.saveMemoryCardBulk(bulklist));
    }

    @ApiOperation(value = "카드목록 페이징 처리해서 가져오기")
    @PostMapping("/memoryCard/paging")
    public ListResult<MemoryCard> searchMemoryCardPaging(@RequestBody MemoryCardPageRequest request ) {
        CardSearchCondition condition
                = CardSearchCondition.builder()
                .question(request.getQuestion())
                .questionType(request.getQuestionType())
                .mainCategorId(request.getMainCategoryId())
                .middleCategoryId(request.getMiddleCategoryId())
                .completed(request.getCompleted())
                .level(request.getLevel())
                .learningCount(request.getLearningCount())
                .page(request.getPage())
                .size(request.getSize())
                .build();

        PageRequest pageRequest = PageRequest.of(condition.getPage(), condition.getSize());
        //Page<MemoryCard> result = cardService.searchMemoryCardPageing(condition, pageRequest);
        Page<MemoryCard> result = cardService.searchMemoryCardPageing(condition, pageRequest);

        //test
        return responseService.getListResult(result.getContent());

    }

    @ApiOperation(value = "대분류 Select Option 가져오기")
    @GetMapping("/mainCategory/selectOption")
    public ListResult<SelectOptionResponse> getMainCategorySelectOption() {
        return responseService.getListResult(cardService.getSelectOptionMainCategory());
    }

    @ApiOperation(value = "중분류 Select Option 가져오기")
    @GetMapping("/middleCategory/selectOption")
    public ListResult<SelectOptionResponse> getMiddleCategorySelectOption() {
        return responseService.getListResult(cardService.getSelectOptionMiddleCategory());
    }

    @ApiOperation(value = "카드목록 페이징 처리해서 가져오기")
    @GetMapping("/memoryCard/next")
    public PageResult<MemoryCardResponse> searchMemoryCardNext(@RequestParam int page ) {

        CardSearchCondition condition = new CardSearchCondition();

        PageRequest pageRequest = PageRequest.of(page, 10);
        //Page<MemoryCard> result = cardService.searchMemoryCardPageing(condition, pageRequest);
        Page<MemoryCardResponse> result = toResponse(cardService.searchMemoryCardPageing(condition, pageRequest));

        return responseService.getPageResult(result);

    }

    @ApiOperation(value = "검색을 통한 카드목록 페이징 처리해서 가져오기")
    @GetMapping("/memoryCard/next/search")
    public PageResult<MemoryCardResponse> searchMemoryCardNextSearch(@RequestParam int page, @RequestParam  String middleCategoryId ) {

        CardSearchCondition condition = new CardSearchCondition();
        condition.setMiddleCategoryId(middleCategoryId);

        PageRequest pageRequest = PageRequest.of(page, 10);
        //Page<MemoryCard> result = cardService.searchMemoryCardPageing(condition, pageRequest);
        Page<MemoryCardResponse> result = toResponse(cardService.searchMemoryCardPageing(condition, pageRequest));

        return responseService.getPageResult(result);

    }

    public Page<MemoryCardResponse> toResponse(Page<MemoryCard> memoryCards) {
        Page<MemoryCardResponse> memoryCardResponses = memoryCards.map(m ->
                MemoryCardResponse.builder()
                        .id(m.getId())
                        .num1(m.getNum1())
                        .num2(m.getNum2())
                        .num3(m.getNum3())
                        .num4(m.getNum4())
                        .middleCategoryId(m.getMiddleCategory().getId())
                        .explanation(m.getExplanation())
                        .rightAnswer(m.getRightAnswer())
                        .rightAnswerNum(m.getRightAnswerNum())
                        .question(m.getQuestion())
                        .questionType(m.getQuestionType())
                        .level(m.getLevel())
                        .build());
                return memoryCardResponses;
    }

    //TODO 대분류 코드로부터 중분류 코드 가져오기 - controller
    //대분류 코드로부터 중분류 코드 가져오기
    @ApiOperation(value = "대분류 코드로부터 중분류 코드 가져오기")
    @GetMapping("/middleCategory/mainCategoryCode")
    public ListResult<MiddleCategory> getMiddleCategoryByMainCatId(@RequestParam int id) {
        return responseService.getListResult(cardService.findMiddleCategoryByMainCategoryId(id));
    }

    @ApiOperation(value = "대분류 검색조건 신택시 연관 중분류 코드 Select 목록 가져오기")
    @GetMapping("/middleCategory/byMainCategory")
    public ListResult<SelectOptionResponse> getMiddleCategoryByMainCat(@RequestParam int id) {

        MiddleCategorySearchCondition condition = new MiddleCategorySearchCondition();
        condition.setId(id);

        ListResult<SelectOptionResponse> result
                = responseService.getListResult(cardService.getMiddleCategoryByMainCat(condition));
        return result;

    }



}
