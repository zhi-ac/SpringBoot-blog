package cn.sheng.blog.mapper;

import cn.sheng.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User checkUser(String username, String password);
}
