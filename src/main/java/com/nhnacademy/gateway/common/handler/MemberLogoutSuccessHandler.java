package com.nhnacademy.gateway.common.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class MemberLogoutSuccessHandler implements LogoutSuccessHandler {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("SESSIONID")){
                    redisTemplate.delete(cookie.getValue());

                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);


                }
            }
        }

        response.sendRedirect("/auth/login");
    }
}
