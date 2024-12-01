package com.nhnacademy.gateway.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    private long taskId;
    private String content;

}
