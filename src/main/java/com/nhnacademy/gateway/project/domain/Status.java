package com.nhnacademy.gateway.project.domain;

public enum Status {
    IN_PROGRESS("진행중"),
    FINISH("끝"),
    TODO("예정");

    private final String name;

    // 생성자
    Status(String name) {
        this.name = name;
    }

    // name 값을 반환하도록 toString() 메서드 수정
    @Override
    public String toString() {
        return name;
    }
}
