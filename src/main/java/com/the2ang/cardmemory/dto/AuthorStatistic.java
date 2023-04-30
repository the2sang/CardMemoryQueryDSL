package com.the2ang.cardmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorStatistic {
    private String authorName;
    private Long bookCount;
}
