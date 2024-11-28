package com.nhnacademy.gateway.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Member {
    private long memberId;
    private String id;
    private String name;
    private String email;
}
