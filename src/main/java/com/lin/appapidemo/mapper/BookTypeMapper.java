package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.BookType;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookTypeMapper extends MyMapper<BookType> {
    @Select("select * from t_booktype where btid=#{btid}")
    BookType selectByBtid(@Param("btid")int btid);

    @Select("<script> "+
            "select * from t_booktype"+
            " <where> "+
            " <if test=\"name !=null\">name like concat('%',concat(#{name},'%'))</if>"+
            " <if test=\"time !=null\">and time like concat('%',concat(#{time},'%'))</if>"+
            " </where> "+
            " </script> "
    )
    @Results({
            @Result(id=true,column="btid",property = "btid"),
            @Result(column = "name",property = "name"),
            @Result(column = "time",property = "time")
    })
    List<BookType> findAllWithTerms(@Param("name")String name,@Param("time")String time);
}
