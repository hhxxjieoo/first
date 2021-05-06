package com.hhj.controller;

import com.hhj.entity.Project;
import com.hhj.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectHandler {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public List<Project> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return projectRepository.findAll(index, limit);
    }

    @GetMapping("/count")
    public int count() {
        return projectRepository.count();
    }

    @GetMapping("/findById/{id}")
    public Project findById(@PathVariable("id") int id) {
        return projectRepository.findById(id);
    }

    @PostMapping("/addProject")
    public void addProject(@RequestBody Project project) {
        projectRepository.addProject(project);
    }

    @PutMapping("/updateProject")
    public void updateProject(@RequestBody Project project) {
        projectRepository.updateProject(project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") int id) {
        projectRepository.deleteProject(id);
    }
}
