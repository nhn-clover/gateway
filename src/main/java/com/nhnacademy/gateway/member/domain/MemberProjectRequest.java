package com.nhnacademy.gateway.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MemberProjectRequest {

    private String memberId;
    private long projectId;

}
