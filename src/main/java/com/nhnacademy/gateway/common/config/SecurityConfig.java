package com.nhnacademy.gateway.common.config;

import com.nhnacademy.gateway.common.filter.MemberAuthenticationFilter;
import com.nhnacademy.gateway.common.handler.CustomAuthenticationSuccessHandler;
import com.nhnacademy.gateway.common.handler.MemberLogoutSuccessHandler;
import com.nhnacademy.gateway.common.service.CustomDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final RedisTemplate<String , Object> redisTemplate;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.addFilterBefore(new MemberAuthenticationFilter(redisTemplate),
                UsernamePasswordAuthenticationFilter.class);

        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(authorizedRequest ->
                authorizedRequest.requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()
        ).formLogin( formLogin ->
                        formLogin.loginPage("/auth/login")
                                .usernameParameter("id")
                                .passwordParameter("password")
                                .loginProcessingUrl("/login/process")
                                .successHandler(new CustomAuthenticationSuccessHandler(redisTemplate))
        ).logout( logout ->
                logout.logoutSuccessHandler(new MemberLogoutSuccessHandler(redisTemplate))
                        .logoutUrl("/auth/logout")
        );

        return http.build();
    }

    @Bean
    @Profile("dev")
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder passwordEncoder = passwordEncoder(); // 재사용
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin")) // BCrypt로 암호화
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }




}
