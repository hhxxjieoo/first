package com.hhj.entity;

import lombok.Data;

@Data
public class Admin extends Account {

    private int id;
    private String username;
    private String password;

}
