package com.sparta.spring04.service;

import com.sparta.spring04.domain.entity.Memo;
import com.sparta.spring04.repository.MemoRepository;
import com.sparta.spring04.domain.Dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;


    @Transactional
    public String update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("ID가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return "수정완료";
    }

}
