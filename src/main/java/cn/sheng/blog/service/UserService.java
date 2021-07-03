package cn.sheng.blog.service;

import cn.sheng.blog.pojo.User;

public interface UserService {
    User checkUser(String username, String password);
}
