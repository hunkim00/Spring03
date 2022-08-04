package com.sparta.spring04.domain.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String passwordConfirm;


}



