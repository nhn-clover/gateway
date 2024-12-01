package com.nhnacademy.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Project {

    private long project_id;
    private String project_name;
    private Status status;
    private long adminId;

}
