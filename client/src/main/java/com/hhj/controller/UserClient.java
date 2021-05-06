package com.hhj.controller;


import com.hhj.entity.User;
import com.hhj.entity.UserVo;
import com.hhj.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/userClient")
public class UserClient {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return userFeign.findAll(page, limit);
    }

    //修改
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_update");
        modelAndView.addObject("user", userFeign.findById(id));
        modelAndView.addObject("allRole", userFeign.findAllRole());
        return modelAndView;
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        System.out.println(user);
        userFeign.updateUser(user);
        return "redirect:/accountClient/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        userFeign.deleteById(id);
        return "redirect:/accountClient/redirect/user_manage";
    }

    @GetMapping("/toAddPage")
    public String toAddPage(Model model) {
        model.addAttribute("allRole", userFeign.findAllRole());
        return "user_add";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userFeign.addUser(user);
        return "redirect:/accountClient/redirect/user_manage";
    }

}
