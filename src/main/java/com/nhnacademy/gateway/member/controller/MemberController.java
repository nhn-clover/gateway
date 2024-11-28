package com.nhnacademy.gateway.member.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/myprojects")
    public String view(
//            @AuthenticationPrincipal Member member,
            @PathVariable String id,
            Model model
    ) {

        // TODO 멤버 컨트롤러
        // id의 멤버 정보를 서비스에서 가져오거나 페인클라이언트로 어카운트 서버에서 받아와야함
        

        // 자신의 아이디로 프로젝트 리스트를 받아와서 모델에 넘겨주기
//        model.addAttribute("projectList", projectList);

        return "member/memberView";
    }

}
