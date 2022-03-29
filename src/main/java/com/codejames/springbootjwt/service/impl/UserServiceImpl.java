package com.codejames.springbootjwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codejames.springbootjwt.entity.User;
import com.codejames.springbootjwt.mapper.UserMapper;
import com.codejames.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Autowired
    UserMapper userMapper;

    public User findByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getUsername, username);
        return userMapper.selectOne(queryWrapper);
    }

    public User findById(String id) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getId, id);
        return userMapper.selectOne(queryWrapper);
    }
}
