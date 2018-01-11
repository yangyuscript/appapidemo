package com.lin.appapidemo.mapper.shixun;

import com.lin.appapidemo.model.shixun.Reader;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReaderMapper extends MyMapper<Reader>{
    @Select("select * from t_reader where rid=#{rid}")
    Reader selectById(@Param("rid") int rid);
    @Select("select * from t_reader where account=#{account}")
    Reader selectWholeByAccount(@Param("account") String account);
    @Select("select * from t_reader where account like concat('%',concat(#{account},'%'))")
    List<Reader> selectByAccount(@Param("account") String account);
}
