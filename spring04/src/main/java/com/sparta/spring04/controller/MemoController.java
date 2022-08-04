package com.sparta.spring04.controller;


import com.sparta.spring04.domain.Dto.MemoResponseDto;
import com.sparta.spring04.domain.entity.Comment;
import com.sparta.spring04.domain.entity.Memo;
import com.sparta.spring04.domain.Mapping.MemoMapping;
import com.sparta.spring04.domain.Dto.MemoRequestDto;
import com.sparta.spring04.repository.CommentRepository;
import com.sparta.spring04.repository.MemoRepository;
import com.sparta.spring04.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private  final CommentRepository commentRepository;

    //게시글 보여주기
    @GetMapping("/api/memos")
    public List<MemoMapping> readMemo() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByCreatedAt(start, end);
    }

    //게시글 작성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // 게시글 상세조회
    @PostMapping("/api/memos/{id}")
    public MemoResponseDto pwMemo(@PathVariable Long id){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시물이 없습니다.")
        );
        List<Comment> comment = commentRepository.findByCmId(id);
        return new MemoResponseDto(memo, comment);
    }

    //게시글 수정
    @PutMapping("/api/memos/{memoid}")
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long delete(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }



}



