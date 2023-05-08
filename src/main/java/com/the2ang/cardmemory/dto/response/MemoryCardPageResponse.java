package com.the2ang.cardmemory.dto.response;

import com.the2ang.cardmemory.dto.MemoryCardAddDto;
import lombok.Data;

@Data
public class MemoryCardPageResponse {
    private int totalPages;
    private MemoryCardAddDto memoryCardAddDto;

}
