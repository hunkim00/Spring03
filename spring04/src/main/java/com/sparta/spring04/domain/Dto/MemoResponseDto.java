package com.sparta.spring04.domain.Dto;

import com.sparta.spring04.domain.Timestamped;
import com.sparta.spring04.domain.entity.Comment;
import com.sparta.spring04.domain.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemoResponseDto extends Timestamped {
    Long id;
    String title;
    String contents;
    String username;
    List<Comment> comment;

    LocalDateTime createAt;

    LocalDateTime modifiedAt;

    public MemoResponseDto(Memo memo, List<Comment>comment) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.username = memo.getAuthor();
        this.comment = comment;
        this.createAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }


    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.username = memo.getAuthor();
        this.createAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
