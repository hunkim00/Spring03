package com.sparta.spring04.domain.Mapping;

import java.time.LocalDateTime;

public interface CommentMapping {
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getComment();
}


