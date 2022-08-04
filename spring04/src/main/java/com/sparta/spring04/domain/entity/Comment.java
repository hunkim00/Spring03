package com.sparta.spring04.domain.entity;

import com.sparta.spring04.domain.Dto.CommentRequestDto;
import com.sparta.spring04.domain.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity

public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private Long cmId;

    @Column(nullable = false)
    private String comment;




    public Comment(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
        this.cmId = requestDto.getCmId();
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}
