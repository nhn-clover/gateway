package com.nhnacademy.gateway.member.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private long id;
    private String memberId;
    private String name;
    private String password;
    private String email;
    private Status status;

    public Member(String memberId, String password,String name, String email, Status status) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
    }
}
