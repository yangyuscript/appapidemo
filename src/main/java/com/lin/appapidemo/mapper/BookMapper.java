package com.lin.appapidemo.mapper;

import com.lin.appapidemo.model.Book;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper extends MyMapper<Book>{
    /**
     * 根据bid删除书籍
     * @param bid
     */
    @Delete("delete from t_book where bid=#{bid}")
    void deleteByBid(int bid);
    /**
     *连表查询出Book详细信息（发布者信息）
     *@params:bid
     *@return:Book
     *@date: 19:46 2017/12/21
     **/
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

    /**
     *模糊查询Book（包括发布者详细信息）
     *@params:bookname,condi,time
     *@return:List<Book>
     *@date: 21:01 2017/12/21
     **/
    @Select("<script> "+
            "select * from t_book"+
            " <where> "+
            " <if test=\"bookname !=null\">bookname like concat('%',concat(#{bookname},'%'))</if>"+
            " <if test=\"condi != 2\">condi = #{condi}</if>"+
            " <if test=\"time !=null\">time like concat('%',concat(#{time},'%'))</if>"+
            " </where> "+
            " </script> "
            )
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
    List<Book> selectAllWithTerms(@Param("bookname") String bookname,@Param("condi") int condi,@Param("time") String time);
}
