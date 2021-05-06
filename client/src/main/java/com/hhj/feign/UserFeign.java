package com.hhj.feign;


import com.hhj.entity.Role;
import com.hhj.entity.User;
import com.hhj.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    public UserVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/user/findAllRole")
    public List<Role> findAllRole();

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") int id);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);

    @PutMapping("/user/updateUser")
    public void updateUser(User user);

    @PostMapping("/user/addUser")
    public void addUser(User user);

}
