package com.the2ang.cardmemory.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReqDto {

    private String nickname;
    private String password;
    private String email;



}
