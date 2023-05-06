package com.the2ang.cardmemory.dto.jwt;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
public class TokenInfo {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpireTime;
    private String accessTokenExpireDate;
}

