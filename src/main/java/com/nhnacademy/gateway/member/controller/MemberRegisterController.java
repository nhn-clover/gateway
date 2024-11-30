package com.nhnacademy.gateway.member.controller;

import com.nhnacademy.gateway.member.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/register")
public class MemberRegisterController {

    @GetMapping
    public String register() {
        return "/auth/register";
    }

    @PostMapping
    public String register(
        @RequestParam("id") String id,
        @RequestParam("password") String password,
        @RequestParam("email") String email
    ) {
        Member member = new Member(id, password, email);

        // TODO 어카운트 서버로 멤버 등록 요청 전송

        // 등록 처리 후 로그인으로 다시 이동
        return "redirect:/auth/login";
    }

}
