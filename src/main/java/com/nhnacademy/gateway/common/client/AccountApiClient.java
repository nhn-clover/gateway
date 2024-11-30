package com.nhnacademy.gateway.common.client;

import com.nhnacademy.gateway.member.domain.MemberCreateRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// todo account api port 수정시 여기서 수정
@FeignClient(name="AccountApiClient", url = "http://localhost:3333")
public interface AccountApiClient {

    @PostMapping(value = "/members/register", consumes = "application/json")
    public ResponseEntity register(@RequestBody MemberCreateRequest memberCreateRequest);

}
