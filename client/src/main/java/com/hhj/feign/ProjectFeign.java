package com.hhj.feign;

import com.hhj.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "project")
public interface ProjectFeign {

    @GetMapping("/project/findAll/{index}/{limit}")
    public List<Project> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/project/count")
    public int count();

    @GetMapping("/project/findById/{id}")
    public Project findById(@PathVariable("id") int id);

    @PostMapping("/project/addProject")
    public void addProject(@RequestBody Project project);

    @PutMapping("/project/updateProject")
    public void updateProject(@RequestBody Project project);

    @DeleteMapping("/project/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") int id);
}
