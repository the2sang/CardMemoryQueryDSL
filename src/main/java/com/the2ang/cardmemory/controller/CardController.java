package com.the2ang.cardmemory.controller;


import com.the2ang.cardmemory.controller.response.CommonResponse;
import com.the2ang.cardmemory.controller.response.CommonResult;
import com.the2ang.cardmemory.controller.response.ListResult;
import com.the2ang.cardmemory.dto.MainCategoryDto;
import com.the2ang.cardmemory.dto.MemoryCardDto;
import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.service.CardService;
import com.the2ang.cardmemory.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. 플레시 카드 서비스"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {

    private final CardService cardService;

    private final ResponseService responseService;

    @ApiOperation(value = "대분류 저장", notes = "대분류 저장하기")
    @PostMapping("/mainCategory/new")
    public CommonResult saveMainCategory(@RequestBody @Valid MainCategoryDto request) {

        return responseService.getSingleResult(cardService.saveMainCategory(request.toEntity()));
    }

    @ApiOperation(value = "중분류 저장히기")
    @PostMapping("/middleCategory/new")
    public CommonResult saveMiddleCategory(@RequestBody @Valid MiddleCategoryDto request) {
        return responseService.getSingleResult(cardService.saveMiddleCategory(request.toEntity()));
    }

    @ApiOperation(value = "메모리 카드 저장하기", notes = "메모리 카드 저장")
    @PostMapping("/memorycard/new")
    public CommonResult saveMemoryCard(@RequestBody @Valid MemoryCardDto request) {
        return responseService.getSingleResult(cardService.saveMemoryCard(request.toEntity()));
    }



    @ApiOperation(value = "중분류 코드로 메모리 카드 가져오기", notes = "중분류 코드로 메모리 카드 조회")
    @GetMapping("/memorycard/middlecode")
    public ListResult<MemoryCardDto> findMamoryCardByMiddleCategoryId(@RequestParam String param) {
        ListResult<MemoryCardDto> result = responseService.getListResult(cardService.findMemoryCardByMiddleCodeFetchJoin(Integer.valueOf(param)));
       // return responseService.getListResult(jacksonObjectMapper().registerModule(Hibernate5Module())
       //         .writeValueAsString(cardService.findMemoryCardByMiddleCodeFetchJoin(Integer.valueOf(param))));

       return result;
    }


    //벌크로 저장
    @ApiOperation(value = "카드 학습 벌크로 저장하기", notes = "카드 학습 벌크저장")
    @PostMapping("/memorycard/bulksave")
    public CommonResult saveMemoryCardBulk(@RequestBody @Valid List<MemoryCard> bulklist) {
        return responseService.getSingleResult(cardService.saveMemoryCardBulk(bulklist));
    }


}
