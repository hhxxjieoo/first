package com.hhj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectVO {

    private int code;
    private String msg;
    private int count;
    private List<Project> data;
}
