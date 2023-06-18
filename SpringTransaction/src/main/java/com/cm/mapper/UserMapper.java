package com.cm.mapper;
import com.cm.pojo.User;

import java.util.List;

public interface UserMapper {

    // 获取所有用户信息
    public List<User> getUsers();

    // 增加用户信息
    public int insertUser(User user);

    // 删除用户信息
    public int deleteUser(int id);

    // 修改用户信息
    public int UpdateUser(User user);

}
