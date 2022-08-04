package com.sparta.spring04.domain.Dto;


import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String author;
    private String title;
    private String contents;
    private String password;



    public MemoRequestDto(String author, String title, String contents, String password){
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }
    }



