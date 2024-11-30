package com.nhnacademy.gateway.member.controller;

import com.nhnacademy.gateway.common.client.AccountApiClient;
import com.nhnacademy.gateway.member.domain.Member;
import com.nhnacademy.gateway.member.domain.MemberCreateRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/register")
public class MemberRegisterController {

    @Autowired
    private AccountApiClient accountApiClient;

    @GetMapping
    public String register() {
        return "/auth/register";
    }

    @PostMapping
    public String register(
            @Valid @RequestBody MemberCreateRequest request
            ) {

        // TODO 어카운트 서버로 멤버 등록 요청 전송
        accountApiClient.register(request);

        // 등록 처리 후 로그인으로 다시 이동
        return "redirect:/auth/login";
    }

}
