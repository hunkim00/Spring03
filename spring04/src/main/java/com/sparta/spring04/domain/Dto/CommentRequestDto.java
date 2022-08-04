package com.sparta.spring04.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    private Long id;
    private Long cmId;
    private String comment;


}
