package com.nhnacademy.gateway.common.service;

import com.nhnacademy.gateway.common.client.AccountApiClient;
import com.nhnacademy.gateway.member.domain.Member;
import com.nhnacademy.gateway.member.domain.MyMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Profile("team")
@Slf4j
public class CustomDetailService implements UserDetailsService {
    // feign client
    // Member 가져오는 일을 한 후 ?
    // Academy User
    private final RedisTemplate<String, Object> redisTemplate;
    private final AccountApiClient accountApiClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Redis -> feign client로 바꿔서

        log.info("call load User By Username");
        Member member = accountApiClient.getMember(username);
        log.info("member : {}", member);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches("test", member.getPassword());
        log.info("matches :{}", matches);


        return new AuthenticatedMember(member.getMemberId(),member.getPassword() );
    }
}
