package com.proxy.service.Impl;

import com.proxy.service.IUserService;

public class UserServiceA implements IUserService {
    @Override
    public void insert(String name) {
        System.out.println(String.format("用户[name:%s]插入成功!", name));
    }
}
