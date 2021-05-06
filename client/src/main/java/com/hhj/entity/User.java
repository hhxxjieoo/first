package com.hhj.entity;

import lombok.Data;

@Data
public class User extends Account {

    private int uid;
    private String username;
    private String password;
    private int sex;
    private String email;
    private int telephone;
    private String qq;
    private String note;
    private Role role;

}
