package com.nhnacademy.gateway.milestone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Milestone {
    private long milestoneId;
    private String projectId;
    // TODO 마일스톤 객체 저장 (마일스톤이 멀 저장해야 하는지 모르겠음)
}
