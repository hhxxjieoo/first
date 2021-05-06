package com.hhj.controller;

import com.hhj.entity.Role;
import com.hhj.entity.User;
import com.hhj.entity.UserVo;
import com.hhj.repository.RoleRepository;
import com.hhj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserHandler {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

/*    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "user的端口" + this.port;
    }*/

    @GetMapping("/findAll/{page}/{limit}")
    public UserVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        return new UserVo(0, "", userRepository.count(), userRepository.findAll((page - 1) * limit, limit));
    }

    @GetMapping("/findAllRole")
    public List<Role> findAllRole() {
        return roleRepository.findAllRole();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userRepository.updateUser(user);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userRepository.addUser(user);
    }
}

