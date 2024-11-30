package com.nhnacademy.gateway.member.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long myMemberId;
    String name;
    String id;
    String password;
}
