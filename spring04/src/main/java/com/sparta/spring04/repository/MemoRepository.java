package com.sparta.spring04.repository;

import com.sparta.spring04.domain.entity.Memo;
import com.sparta.spring04.domain.Mapping.MemoMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<MemoMapping> findAllByModifiedAtBetweenOrderByCreatedAt(LocalDateTime start, LocalDateTime end);

}
