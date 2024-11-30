package com.nhnacademy.gateway.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long id;
    private String memberId;
    private String name;
    private String email;
    private Status status;

    public Member(String memberId, String name, String email, Status status) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.status = status;
    }
}
