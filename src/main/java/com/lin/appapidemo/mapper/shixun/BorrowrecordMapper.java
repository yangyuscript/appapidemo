package com.lin.appapidemo.mapper.shixun;

import com.lin.appapidemo.model.shixun.Borrowrecord;
import com.lin.appapidemo.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowrecordMapper extends MyMapper<Borrowrecord>{
    @Select("<script> "+
            "select * from t_borrowrecord"+
            " <where> "+
            " rid=#{rid}"+
            " </where> "+
            " </script> "
    )
    @Results({
            @Result(id=true,column="bid",property = "bid"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "raccount",property = "raccount"),
            @Result(column = "aid",property = "aid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "time",property = "time"),
            @Result(column = "inttime",property = "inttime"),
            @Result(column="aid",property = "album",
                    one=@One(select="com.lin.appapidemo.mapper.shixun.AlbumMapper.selectById")
            ),
            @Result(column="sid",property = "subalbum",
                    one=@One(select="com.lin.appapidemo.mapper.shixun.SubalbumMapper.selectById")
            )
    })
    List<Borrowrecord> selectAllInfoByrid(@Param("rid")int rid);
    /**
     *根据借阅者账号模糊查询借阅记录
     *@params:
     *@return:
     *@date: 22:12 2018/1/10
     **/
    @Select("<script> "+
            "select * from t_borrowrecord"+
            " <where> "+
            " raccount like concat('%',concat(#{raccount},'%'))"+
            " </where> "+
            " </script> "
    )
    @Results({
            @Result(id=true,column="bid",property = "bid"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "raccount",property = "raccount"),
            @Result(column = "aid",property = "aid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "time",property = "time"),
            @Result(column = "inttime",property = "inttime"),
            @Result(column="rid",property = "reader",
                    one=@One(select="com.lin.appapidemo.mapper.shixun.ReaderMapper.selectById")
            ),
            @Result(column="aid",property = "album",
                    one=@One(select="com.lin.appapidemo.mapper.shixun.AlbumMapper.selectById")
            ),
            @Result(column="sid",property = "subalbum",
                    one=@One(select="com.lin.appapidemo.mapper.shixun.SubalbumMapper.selectById")
            )
    })
    List<Borrowrecord> selectAllInfoByRaccount(@Param("raccount")String raccount);
}
