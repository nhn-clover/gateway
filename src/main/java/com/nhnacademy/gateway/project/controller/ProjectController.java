package com.nhnacademy.gateway.project.controller;

import com.nhnacademy.gateway.common.client.AccountApiClient;
import com.nhnacademy.gateway.common.client.TaskApiClient;
import com.nhnacademy.gateway.project.domain.Project;
import com.nhnacademy.gateway.project.domain.ProjectRequest;
import com.nhnacademy.gateway.project.domain.Status;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ProjectController {

    private final TaskApiClient taskApiClient;
    private final AccountApiClient accountApiClient;

    @GetMapping
    public String viewListProject(Model model){

        List<Long> projectIds = accountApiClient.getMemberProjects(1L);
        List<Project> projects = new ArrayList<>();


        for (Long projectId : projectIds){
            projects.add(taskApiClient.getProject(projectId));
        }


        model.addAttribute("projects", projects);

        return "/project/projectList";
    }

//    @GetMapping
//    public String createProjectView(){
//        return "project/createProject";
//    }
    @PostMapping
    public String createProject(@AuthenticationPrincipal UserDetails userDetails,
                                @ModelAttribute ProjectRequest request){

        log.info("hello --------------------- hello");

        request.setStatus(Status.TODO.name());
        request.setAdminId(1L);

        taskApiClient.createProject(request);

        log.info("username : {}" , userDetails.getUsername());
        log.info("password : {}" , userDetails.getPassword());
        log.info("projectName : {}", request.getProjectName());
        // TODO 여기서 task 로 보냄
        return "home";
    }


    @GetMapping("/create")
    public String createViewProject(@AuthenticationPrincipal UserDetails userDetails){
        return "/project/createProject";
    }

    @GetMapping("/{projectId}")
    public String viewDetailProject(@PathVariable("projectId") long projectId, Model model){
        log.info("projectId : {}", projectId);

        Project project = taskApiClient.getProject(projectId);

        List<String> tasks = List.of("테스크1", "테스크2","테스크4", "테스크5");

        log.info("projectName : {}", project.getProject_name());

        model.addAttribute("projectName", project.getProject_name());
        model.addAttribute("tasks", tasks);

        return "/project/projectDetail";
    }




//    @GetMapping("/{projectId}/detail")
//    public String getProjectDetail(@PathVariable long projectId, Model model) {
//
//        return "projectDetail"
//    }




}
