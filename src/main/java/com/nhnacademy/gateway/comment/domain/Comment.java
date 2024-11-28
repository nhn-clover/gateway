package com.nhnacademy.gateway.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Comment {
    private long commentId;
    private long taskId;
    private String writerId;    // 작성자 멤버의 인덱스
    private String content;
}
