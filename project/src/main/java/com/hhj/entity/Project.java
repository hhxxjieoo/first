package com.hhj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Project {

    private int id;
    private String projectName;
    private String projectLeader;
    private String status;
    private Date createdTime;
    private Date startTime;
    private Date endTime;
    private String difficulty;
    private String progress;

}
