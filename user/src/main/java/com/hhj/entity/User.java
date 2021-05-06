package com.hhj.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String nickname;
    private int sex;
    private String email;
    private int telephone;
    private String qq;
    private String note;
    private Role role;

}
