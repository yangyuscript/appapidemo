package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.Position;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionMapper extends MyMapper<Position> {
    @Select("select pid,userid,address,time from t_position where userid=#{userid} order by time desc")
    List<Position> findAllByUserid(@Param("userid")int userid);
}
