package com.nhnacademy.gateway.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String memberId;
    private String password;
}
