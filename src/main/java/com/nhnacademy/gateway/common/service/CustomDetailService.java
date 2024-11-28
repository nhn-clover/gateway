package com.nhnacademy.gateway.common.service;

import com.nhnacademy.gateway.member.domain.MyMember;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Profile("team")
public class CustomDetailService implements UserDetailsService {
    // feign client
    // Member 가져오는 일을 한 후 ?
    // Academy User
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Redis -> feign client로 바꿔서
        // redis Member -> username -> Member 객체를 받아서
//        Optional<MyMember> myMemberById = memberRepository.findMyMemberById(username);

//
//        if(myMemberById.isPresent()){
//            MyMember myMember = myMemberById.get();
//            return new AuthenticatedMember(myMember.getId(), myMember.getPassword());
//        }

        throw new RuntimeException();
    }
}
