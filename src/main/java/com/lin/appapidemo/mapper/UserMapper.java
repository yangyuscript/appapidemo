package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.User;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MyMapper<User> {
    @Insert("insert into t_user (email,nickname,password,head,credit,condi) values(#{email},#{nickname},#{password},#{head},#{credit},#{condi})")
    void insertUser(User user);
    @Select("select * from t_user where userid=#{userid}")
    User selectById(@Param("userid") int userid);
    @Select("select * from t_user where nickname=#{nickname}")
    User selectByName(@Param("nickname") String nickname);
    @Select("select userid,email,nickname,password,head,credit,condi from t_user where email=#{email}")
    User selectByEmail(@Param("email")String email);
}
