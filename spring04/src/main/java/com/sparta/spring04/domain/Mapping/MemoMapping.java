package com.sparta.spring04.domain.Mapping;

import java.time.LocalDateTime;

public interface MemoMapping {
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getTitle();
    String getAuthor();
}
