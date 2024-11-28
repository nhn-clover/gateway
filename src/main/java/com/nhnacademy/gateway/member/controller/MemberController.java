package com.nhnacademy.gateway.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/{id}")
    public String view(
            @PathVariable String id,
            Model model
    ) {
        // TODO id의 멤버 정보를 서비스에서 가져오거나 페인클라이언트로 어카운트 서버에서 받아와야함
        return "member/memberView";
    }
}
