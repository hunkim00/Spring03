package com.sparta.spring04.domain.Dto;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;


    public LoginRequestDto(String username, String password){
        this.username = username;
        this.password = password;
    }


}
