package com.sparta.spring04.controller;

import com.sparta.spring04.domain.entity.Comment;
import com.sparta.spring04.domain.Mapping.CommentMapping;
import com.sparta.spring04.domain.Dto.CommentRequestDto;
import com.sparta.spring04.repository.CommentRepository;
import com.sparta.spring04.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //댓글 조회
    @GetMapping("/api/auth/comment")
    public List<CommentMapping> readComment() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return commentRepository.findAllByModifiedAtBetweenOrderByCreatedAt(start, end);
    }

    @PostMapping("/api/auth/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comment/{id}")
    public String updateMemo(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        return commentService.update(id, requestDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public Long delete(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }

}
