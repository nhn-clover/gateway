package com.nhnacademy.gateway.member.controller;

import com.nhnacademy.gateway.common.client.AccountApiClient;
import com.nhnacademy.gateway.member.domain.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/register")
@RequiredArgsConstructor
public class MemberRegisterController {

    private final AccountApiClient accountApiClient;

    @GetMapping
    public String getRegister() {
        return "/auth/register";
    }

    @PostMapping
    public String register(
            @ModelAttribute MemberCreateRequest request
    ) {
        // TODO 어카운트 서버로 멤버 등록 요청 전송
        accountApiClient.register(request);

        // 등록 처리 후 로그인으로 다시 이동
        return "redirect:/auth/login";
    }

}
