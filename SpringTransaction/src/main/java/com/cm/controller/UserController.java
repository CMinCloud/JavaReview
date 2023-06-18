package com.cm.controller;

import com.cm.mapper.UserMapper;
import com.cm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @Author：CM
 * @Package：com.cm.controller
 * @Project：JavaReview
 * @name：UserController
 * @Date：2023/6/16 9:09
 * @Filename：UserController
 */
@RestController
@RequestMapping("/demo")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/get")
    public List<User> userList(){
        return null;
    }
}
