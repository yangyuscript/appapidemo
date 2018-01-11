package com.lin.appapidemo.mapper.shixun;

import com.lin.appapidemo.model.shixun.Subalbum;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SubalbumMapper extends MyMapper<Subalbum>{
    @Select("select * from t_subalbum where sid=#{sid}")
    Subalbum selectById(@Param("sid") int sid);
    @Select("select * from t_subalbum where number=#{number}")
    Subalbum selectByNumber(@Param("number") String number);
    @Select("select * from t_subalbum where aid=#{aid}")
    List<Subalbum> selectByAid(@Param("aid")int aid);

}
