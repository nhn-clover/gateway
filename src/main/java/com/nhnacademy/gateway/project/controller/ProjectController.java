package com.nhnacademy.gateway.project.controller;

import com.nhnacademy.gateway.project.domain.Project;
import com.nhnacademy.gateway.project.domain.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping
    public String viewListProject(Model model){

        List<Project> projects = new ArrayList<>();

        projects.add(new Project(1L , "프로젝트1", Status.IN_PROGRESS));
        projects.add(new Project(2L , "프로젝트2", Status.IN_PROGRESS));
        projects.add(new Project(3L , "프로젝트3", Status.IN_PROGRESS));


        model.addAttribute("projects", projects);

        return "/project/projectList";
    }

//    @GetMapping
//    public String createProjectView(){
//        return "project/createProject";
//    }
    @PostMapping("/projects")
    public String createProject(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam("projectName") String  projectName){

        log.info("username : {}" , userDetails.getUsername());
        log.info("password : {}" , userDetails.getPassword());
        log.info("projectName : {}", projectName);
        // TODO 여기서 task 로 보냄
        return "home";
    }

    @GetMapping("/{projectId}")
    public String viewDetailProject(@PathVariable("projectId") long projectId, Model model){
        log.info("projectId : {}", projectId);

        List<String> tasks = List.of("테스크1", "테스크2","테스크4", "테스크5");


        model.addAttribute("tasks", tasks);

        return "/project/projectDetail";
    }




//    @GetMapping("/{projectId}/detail")
//    public String getProjectDetail(@PathVariable long projectId, Model model) {
//
//        return "projectDetail"
//    }




}
