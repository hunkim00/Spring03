package com.sparta.spring04.service;

import com.sparta.spring04.domain.entity.Comment;
import com.sparta.spring04.domain.Dto.CommentRequestDto;
import com.sparta.spring04.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;


    @Transactional
    public String update(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return "수정완료";
    }
}
