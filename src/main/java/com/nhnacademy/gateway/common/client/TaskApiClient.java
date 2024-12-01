package com.nhnacademy.gateway.common.client;

import com.nhnacademy.gateway.comment.domain.Comment;
import com.nhnacademy.gateway.comment.domain.CommentRequest;
import com.nhnacademy.gateway.dto.ProjectUpdateDTO;
import com.nhnacademy.gateway.member.domain.ProjectMember;
import com.nhnacademy.gateway.milestone.domain.MileStoneRequest;
import com.nhnacademy.gateway.milestone.domain.Milestone;
import com.nhnacademy.gateway.project.domain.Project;
import com.nhnacademy.gateway.project.domain.ProjectRequest;
import com.nhnacademy.gateway.tag.domain.Tag;
import com.nhnacademy.gateway.tag.domain.TagRequest;
import com.nhnacademy.gateway.task.domain.Task;
import com.nhnacademy.gateway.task.domain.TaskRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TaskApiClient", url = "http://localhost:4444")
public interface TaskApiClient {

    // 프로젝트 하나 조회
    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable("projectId") Long projectId);

    // 해당 프로젝트의 멤버 id목록 조회
    @GetMapping("/project-members/{projectId}")
    public List<Long> getMemberProject(@PathVariable long projectId);

    // 프로젝트에 멤버 추가
    @PostMapping
    public List<Long> addMemberProject(@RequestBody ProjectMember request);

    // 프로젝트 생성
    @PostMapping("/project")
    public Project createProject(@RequestBody ProjectRequest projectRequest);

    // 프로젝트 수정
    @PostMapping("/project/update")
    public Project updateProject(@RequestBody ProjectUpdateDTO projectUpdateDTO);

    // 프로젝트 삭제
    @DeleteMapping("/project/delete/{projectId}")
    public void deleteProject(@PathVariable Long projectId);

    // 특정 프로젝트의 태그 리스트 조회
    @GetMapping("/project/{projectId}/tags")
    public List<Tag> getTags(@PathVariable("projectId") Long projectId);

    // 태그 추가
    @PostMapping("/tag")
    public Tag createTag(@RequestBody TagRequest tagRequest);

    // 태그 수정 (이름)
    @PutMapping("/tags/{tagId}")
    public Tag updateTag(@PathVariable("tagId") Long tagId, @RequestBody TagRequest tagRequest);

    // 태그 삭제
    @DeleteMapping("/tags/{tagId}")
    public void deleteTag(@PathVariable Long tagId);

    // 특정 프로젝트의 태스크 리스트 조회
    @GetMapping("/project/{projectId}/task")
    public List<Task> getTasksByProject(@PathVariable("projectId") long projectId);

    // 태스크 등록
    @PostMapping("/task")
    public Task createTask(@RequestBody TaskRequest taskRequest);

    // 태스크 수정 -  id는 바뀌면 안됨
    @PostMapping("/task/update")
    public Task updateTask(@RequestBody TaskRequest taskRequest);

    // 태스크 삭제
    @DeleteMapping("/tasks/delete/{taskId}")
    public void deleteTask(@PathVariable long taskId);

    // 특정 프로젝트의 마일스톤 리스트 조회
    @GetMapping("/project/{projectId}/milestone")
    public List<Milestone> getMilestones(@PathVariable Long projectId);

    // 마일스톤 추가
    @PostMapping("/milestone")
    public Milestone createMileStone(@RequestBody MileStoneRequest mileStoneRequest);

    // 마일스톤 제거
    @DeleteMapping("/milestones/delete/{milestoneId}")
    public void deleteMileStone(@PathVariable Long milestoneId);

    // 특정 태스크의 코멘트 리스트 조회


    // 코멘트 등록
    @PostMapping("/comments")
    public Comment createComment(@RequestBody CommentRequest commentRequest);

    // 코멘트 제거
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable("commentId")long commentId);

    // 코멘트 수정
    @PostMapping("/comments/{commentId}")
    public Comment updateComment(@PathVariable long commentId, @RequestBody CommentRequest commentRequest);


}
