package com.sparta.spring03.domain;


import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String author;
    private String title;
    private String contents;
    private String password;

}
