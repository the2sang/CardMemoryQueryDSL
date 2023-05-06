package com.the2ang.cardmemory.entity.card;

import com.the2ang.cardmemory.dto.AccountReqDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotBlank
    private String nickname;


    @NotBlank
    private String pw;

    private String email;


    public Account(AccountReqDto accountReqDto) {
        this.nickname = accountReqDto.getNickname();
        this.pw = accountReqDto.getPw();
        this.email = accountReqDto.getEmail();
    }
}