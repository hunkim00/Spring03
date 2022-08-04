package com.sparta.spring04.repository;

import com.sparta.spring04.domain.entity.Comment;
import com.sparta.spring04.domain.Mapping.CommentMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentMapping> findAllByModifiedAtBetweenOrderByCreatedAt(LocalDateTime start, LocalDateTime end);

    List<Comment> findByCmId(Long id);


}
