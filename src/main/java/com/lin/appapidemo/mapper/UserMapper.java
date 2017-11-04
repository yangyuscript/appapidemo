package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.User;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MyMapper<User> {
    @Select("select * from t_user where username=#{username}")
    User selectByName(String username);
}
