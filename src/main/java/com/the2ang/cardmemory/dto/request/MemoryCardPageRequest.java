package com.the2ang.cardmemory.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemoryCardPageRequest {

    private String question;
    private String questionType;
    private String mainCategoryId;
    private String middleCategoryId;
    private String completed;
    private String level;
    private String learningCount;
    private int page;
    private int size;


}
