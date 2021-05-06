package com.hhj.controller;

import com.hhj.entity.Project;
import com.hhj.entity.ProjectVO;
import com.hhj.feign.ProjectFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/projectClient")
public class ProjectClient {

    @Autowired
    private ProjectFeign projectFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public ProjectVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return new ProjectVO(0, "", projectFeign.count(), projectFeign.findAll(index, limit));
    }

    @GetMapping("/count")
    public int count() {
        return projectFeign.count();
    }

    @GetMapping("/findById/{id}")
    public Project findById(@PathVariable("id") int id) {
        return projectFeign.findById(id);
    }

    @PostMapping("/addProject")
    public String addProject(Project project) {
        project.setCreatedTime(new Date());
        projectFeign.addProject(project);
        return "redirect:/accountClient/redirect/project_manage";
    }

    @PutMapping("/updateProject")
    public void updateProject(@RequestBody Project project) {
        projectFeign.updateProject(project);
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        projectFeign.deleteProject(id);
        return "redirect:/accountClient/redirect/project_manage";
    }
}
