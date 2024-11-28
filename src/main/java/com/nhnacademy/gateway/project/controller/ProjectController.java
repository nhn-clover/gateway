package com.nhnacademy.gateway.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ProjectController {

    @GetMapping("/projects")
    public String createProjectView(){
        return "project/createProject";
    }
    @PostMapping("/projects")
    public String createProject(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam("projectName") String  projectName){

        log.info("username : {}" , userDetails.getUsername());
        log.info("password : {}" , userDetails.getPassword());
        log.info("projectName : {}", projectName);
        // TODO 여기서 task 로 보냄
        return "home";
    }

    @GetMapping("/projects/{projectId}")
    public String viewDetailProject(@PathVariable("projectId") long projectId){
        log.info("projectId : {}", projectId);

        return "/project/projectDetail";
    }


}
