package com.lin.appapidemo.mapper.shixun;

import com.lin.appapidemo.model.shixun.Album;
import com.lin.appapidemo.model.shixun.Borrowrecord;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AlbumMapper extends MyMapper<Album>{
    @Select("select * from t_album where aid=#{aid}")
    @Results({
            @Result(id=true,column="aid",property = "aid"),
            @Result(column = "title",property = "title"),
            @Result(column = "author",property = "author"),
            @Result(column = "publisher",property = "publisher"),
            @Result(column = "publishtime",property = "publishtime"),
            @Result(column = "num",property = "num"),
            @Result(column = "descri",property = "descri"),
            @Result(column = "time",property = "time"),
            @Result(column="aid",property = "subalbums",
                    many=@Many(select="com.lin.appapidemo.mapper.shixun.SubalbumMapper.selectByAid")
            )
    })
    Album selectById(@Param("aid") int aid);
    /**
     *根据图书title模糊查询，及该图书所有的副本编号
     *@params:
     *@return:
     *@date: 22:00 2018/1/11
     **/
    @Select("<script> "+
            "select * from t_album"+
            " <where> "+
            " title like concat('%',concat(#{title},'%'))"+
            " </where> "+
            " </script> "
    )
    @Results({
            @Result(id=true,column="aid",property = "aid"),
            @Result(column = "title",property = "title"),
            @Result(column = "author",property = "author"),
            @Result(column = "publisher",property = "publisher"),
            @Result(column = "publishtime",property = "publishtime"),
            @Result(column = "num",property = "num"),
            @Result(column = "descri",property = "descri"),
            @Result(column = "time",property = "time"),
            @Result(column="aid",property = "subalbums",
                    many=@Many(select="com.lin.appapidemo.mapper.shixun.SubalbumMapper.selectByAid")
            )
    })
    List<Album> selectByTitle(@Param("title")String title);
}
