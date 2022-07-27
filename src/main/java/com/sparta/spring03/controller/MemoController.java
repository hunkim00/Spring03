package com.sparta.spring03.controller;


import com.sparta.spring03.domain.*;
import com.sparta.spring03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<MemoMapping> readMemo() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByCreatedAt(start, end);
    }


    @GetMapping("/api/memos/{id}")
    public Memo idMemo(@PathVariable Long id) {
        return memoRepository.findById(id).orElse(null);
    }


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PostMapping("/api/memos/{id}")
    public boolean pwMemo(@PathVariable Long id, @RequestBody MemoCheckRequestDto requestDto ){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시물이 없습니다.")
        );
        return memo.getPassword().equals(requestDto.getPassword());
    }


    @PutMapping("/api/memos/{id}")
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long delete(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

}



