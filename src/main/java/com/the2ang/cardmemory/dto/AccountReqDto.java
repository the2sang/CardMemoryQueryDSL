package com.the2ang.cardmemory.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountReqDto {

    @NotBlank
    private String nickname;
    @NotBlank
    private String pw;

    private String pwck;

    private String email;

    public AccountReqDto(String nickname, String pw, String pwck, String email) {
        this.nickname = nickname;
        this.pw = pw;
        this.pwck = pwck;
        this.email = email;
    }

    public void setEncodePwd(String encodePwd) {
        this.pw = encodePwd;
    }
}