package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMapper extends MyMapper<Book>{
    @Select("select * from t_book where bid=#{bid}")
    @Results({
            @Result(id=true,column="bid",property = "bid"),
            @Result(column = "userid",property = "userid"),
            @Result(column = "bookname",property = "bookname"),
            @Result(column = "bookpic",property = "bookpic"),
            @Result(column = "description",property = "description"),
            @Result(column = "condi",property = "condi"),
            @Result(column = "time",property = "time"),@Result(column="userid",property = "user",
                one=@One(select="com.lin.appapidemo.mapper.UserMapper.selectById")
            )
    })
    Book getBookByBid(@Param("bid") int bid);
}
