package com.the2ang.cardmemory.controller;


import com.the2ang.cardmemory.controller.response.CommonResponse;
import com.the2ang.cardmemory.controller.response.CommonResult;
import com.the2ang.cardmemory.dto.MainCategoryDto;
import com.the2ang.cardmemory.dto.MemoryCardDto;
import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import com.the2ang.cardmemory.service.CardService;
import com.the2ang.cardmemory.service.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {

    private final CardService cardService;

    private final ResponseService responseService;

    @PostMapping("/mainCategory/new")
    public CommonResult saveMainCategory(@RequestBody @Valid MainCategoryDto request) {

        return responseService.getSingleResult(cardService.saveMainCategory(request.toEntity()));
    }

    @PostMapping("/middleCategory/new")
    public CommonResult saveMiddleCategory(@RequestBody @Valid MiddleCategoryDto request) {
        return responseService.getSingleResult(cardService.saveMiddleCategory(request.toEntity()));
    }

    @PostMapping("/memorycard/new")
    public CommonResult saveMemoryCard(@RequestBody @Valid MemoryCardDto request) {
        return responseService.getSingleResult(cardService.saveMemoryCard(request.toEntity()));
    }


    //TODO..

}
