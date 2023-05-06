package com.the2ang.cardmemory.entity.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpireTime;
    private String accessTokenExpireDate;

    public RefreshToken updateToken(String token) {
        this.refreshToken = token;
        return this;
    }

    public RefreshToken(String token, String email) {
        this.refreshToken = token;
        this.email = email;
    }


}