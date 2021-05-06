package com.hhj.entity;

import lombok.Data;

import java.util.List;

@Data
public class ProjectVO {

    private int code;
    private String msg;
    private int count;
    private List<Project> data;
}
