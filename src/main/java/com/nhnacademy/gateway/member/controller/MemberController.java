package com.nhnacademy.gateway.member.controller;

import com.nhnacademy.gateway.project.domain.Project;
import com.nhnacademy.gateway.project.domain.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class MemberController {
    @GetMapping("/members/{memberId}/projects")
    public String memberProjects(@PathVariable(name = "memberId") String memberId,
                                 Model model){
        log.info("memberId : {}", memberId);
        // TODO task 에  GET /api/members/{userId}/projects
        // model 에 추가

        // list로 받고
        List<Project> projects = Arrays.asList(new Project(1L, "project1", Status.TODO),
                new Project(2L, "project2", Status.FINISH),
                new Project(3L, "project3", Status.IN_PROGRESS));

        model.addAttribute("projects",projects);

        return "member/memberProjects";
    }
}
