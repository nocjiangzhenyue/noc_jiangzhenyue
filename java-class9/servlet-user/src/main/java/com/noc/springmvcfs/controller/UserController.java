package com.noc.springmvcfs.controller;

import com.noc.springmvcfs.model.User;
import com.noc.springmvcfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/user", produces = "application/json; charset=utf-8")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser")
    public String  getUser(String name, String age){
        return userService.getUser(name,age);
    }

    /*
     * 功能描述：
     * 传入对象进行数据库插入
     * @author jiangzhenyue
     * @date 2021/9/30 12:08
     * @param user
     * @return String
    */
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody User user){
        boolean addSuccess = userService.addUser(user);
        return addSuccess?"插入成功":"插入失败";
    }

}
