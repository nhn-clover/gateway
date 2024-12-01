package com.nhnacademy.gateway.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class MemberAuthenticationFilter extends OncePerRequestFilter {
    private final RedisTemplate<String , Object> redisTemplate;
    private static final String HASH_NAME = "MEMBER:";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("SESSIONID")){
                    sessionId = cookie.getValue();
                }
            }
        }

        if(sessionId != null){
            String memberId  = (String)redisTemplate.opsForHash().get(HASH_NAME, sessionId);

            // TODO 합치면 다시 하기
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            UserDetails admin = User.builder()
                    .username("admin")
                    .password("admin") // BCrypt로 암호화
                    .roles("ADMIN")
                    .build();

            PreAuthenticatedAuthenticationToken auth = new PreAuthenticatedAuthenticationToken(admin,null,
                    Arrays.asList(new SimpleGrantedAuthority("USER"))
            );
            auth.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(auth);


        }

        filterChain.doFilter(request, response);
    }
}
