package com.nhnacademy.gateway.common.client;

import com.nhnacademy.gateway.member.domain.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// todo account api port 수정시 여기서 수정
@FeignClient(name="AccountApiClient", url = "http://localhost:3333")
public interface AccountApiClient {

    @PostMapping("/members/register")
    public ResponseEntity register(@RequestBody Member member);

}
