package com.nhnacademy.gateway.member.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    DORMANT, ACTIVE, DELETED;

    @JsonCreator
    public static Status formString(String s) {
        return Status.valueOf(s.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }

}
