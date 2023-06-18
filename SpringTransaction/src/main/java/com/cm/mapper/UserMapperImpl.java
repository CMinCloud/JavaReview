package com.cm.mapper;

import com.cm.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    // 引入SqlSessionTemplate对象
    private SqlSessionTemplate sqlSessionTemplate;

    // 使用set方法动态注入SqlSessionTemplate对象
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    // 重写getUsers方法
    public List<User> getUsers() {
        // 获取UserMapper对象
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        // 返回UserMapper对象的getUsers方法
        return userMapper.getUsers();
    }

    @Override
    public int insertUser(User user) {
        // 获取UserMapper对象
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        // 返回UserMapper对象的getUsers方法
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        // 获取UserMapper对象
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        // 返回UserMapper对象的getUsers方法
        return userMapper.deleteUser(id);
    }

    @Override
    public int UpdateUser(User user) {
        // 获取UserMapper对象
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        // 返回UserMapper对象的getUsers方法
        return userMapper.UpdateUser(user);
    }

}
