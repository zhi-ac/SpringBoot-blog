package cn.sheng.blog.service.impl;

import cn.sheng.blog.mapper.UserMapper;
import cn.sheng.blog.pojo.User;
import cn.sheng.blog.service.UserService;
import cn.sheng.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.checkUser(username, MD5Utils.code(password));
        return user;
    }
}
