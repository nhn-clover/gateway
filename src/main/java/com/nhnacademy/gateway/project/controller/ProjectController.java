package com.nhnacademy.gateway.project.controller;

import com.nhnacademy.gateway.project.domain.Project;
import com.nhnacademy.gateway.project.domain.Status;
import com.nhnacademy.gateway.task.domain.Task;
import com.nhnacademy.gateway.task.domain.TaskRequest;
import jakarta.validation.Valid;
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

        projects.add(new Project(1L , "프로젝트1", Status.IN_PROGRESS,1));
        projects.add(new Project(2L , "프로젝트2", Status.IN_PROGRESS,2));
        projects.add(new Project(3L , "프로젝트3", Status.IN_PROGRESS,3));


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


    // 특정 프로젝트의 태스크 리스트 페이지
    @GetMapping("/{projectId}/tasks")
    public String listTasks(@PathVariable("projectId") long projectId, Model model) {
        log.info("Viewing tasks for projectId: {}", projectId);

        // 프로젝트 ID에 해당하는 태스크 데이터 생성
        List<Task> tasks = List.of(
                new Task(1L, "태스크 1"),
                new Task(2L, "태스크 2"),
                new Task(3L, "태스크 3")
        );

        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", tasks);
        return "/project/projectDetail"; // 태스크 리스트 페이지
    }

    // 특정 태스크의 세부 사항 페이지
    @GetMapping("/{projectId}/tasks/{taskId}")
    public String detailTask(@PathVariable("projectId") long projectId,
                             @PathVariable("taskId") long taskId,
                             Model model) {
        log.info("Viewing task details for projectId: {}, taskId: {}", projectId, taskId);

        // 특정 태스크 데이터 생성
        Task task = new Task(taskId, "태스크 " + taskId);

        model.addAttribute("projectId", projectId);
        model.addAttribute("task", task);
        return "/task/task"; // 태스크 세부 사항 페이지
    }

    // 태스크 추가 페이지
    @GetMapping("/{projectId}/tasks/create")
    public String createTaskView(@PathVariable("projectId") long projectId, Model model) {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setProjectId(projectId);
        model.addAttribute("taskRequest", taskRequest);
        return "/task/createTask"; // 태스크 추가 페이지
    }

    // 태스크 추가 처리
    @PostMapping("/{projectId}/tasks")
    public String createTask(@PathVariable("projectId") long projectId,
                             @Valid @ModelAttribute TaskRequest taskRequest,
                             Model model) {
        log.info("Adding new task to projectId: {}", projectId);
        log.info("Task details - taskId: {}, content: {}",
                taskRequest.getTaskId(),
                taskRequest.getContent());

        // 실제 태스크 추가 로직은 생략
        model.addAttribute("message", "태스크가 성공적으로 추가되었습니다!");
        return "redirect:/projects/" + projectId + "/project/projectDetail"; // 태스크 리스트로 리다이렉트
    }

}
