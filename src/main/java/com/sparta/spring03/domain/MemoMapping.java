package com.sparta.spring03.domain;

import java.time.LocalDateTime;

public interface MemoMapping {
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getTitle();
    String getAuthor();
}
