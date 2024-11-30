package com.nhnacademy.gateway.common.client;

import com.nhnacademy.gateway.member.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// todo account api port 수정시 여기서 수정
@FeignClient(name="AccountApiClient", url = "http://localhost:3333")
public interface AccountApiClient {

    // 새 회원 등록 요청
    @PostMapping("/members/register")
    public ResponseEntity register(@RequestBody MemberCreateRequest memberCreateRequest);

    // 회원 정보 가져오기 요청
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable("id") Long id);

    // 로그인 요청 - 로그인 리퀘스트를 전송하면
    @PostMapping("/login")
    public Member login(@RequestBody LoginRequest loginRequest);

    // 멤버 상태 변경
    @PostMapping("/members/{id}")
    public Member statusUpdate(@PathVariable("id") Long id,
                               @RequestBody StatusRequest statusRequest);

    // 멤버 프로젝트 ---------------------
    // 멤버의 프로젝트 목록 조회
    @GetMapping("/member-projects/{memberId}")
    public List<Long> getMemberProjects(@PathVariable("memberId") Long memberId);

    // 멤버에 프로젝트 추가
    @PostMapping("/member-projects")
    public ResponseEntity addMemberProjects(@RequestBody MemberProjectRequest request);

    // 멤버에서 프로젝트 제거
    @DeleteMapping("/member-projects")
    public ResponseEntity deleteMemberProjects(@RequestBody MemberProjectRequest request);

}
