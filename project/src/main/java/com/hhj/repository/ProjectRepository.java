package com.hhj.repository;

import com.hhj.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectRepository {

    public List<Project> findAll(int index,int limit);

    public int count();

    public Project findById(int id);

    public void addProject(Project project);

    public void deleteProject(int id);

    public void updateProject(Project project);
}
