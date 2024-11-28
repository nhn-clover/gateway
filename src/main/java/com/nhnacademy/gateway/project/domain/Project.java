package com.nhnacademy.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Project {

    private long project_id;
    private String project_name;
    private Status status;



}
