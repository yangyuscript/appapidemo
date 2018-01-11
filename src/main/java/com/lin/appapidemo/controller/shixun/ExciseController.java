package com.lin.appapidemo.controller.shixun;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.appapidemo.mapper.shixun.AlbumMapper;
import com.lin.appapidemo.mapper.shixun.BorrowrecordMapper;
import com.lin.appapidemo.mapper.shixun.ReaderMapper;
import com.lin.appapidemo.mapper.shixun.SubalbumMapper;
import com.lin.appapidemo.model.User;
import com.lin.appapidemo.model.shixun.Album;
import com.lin.appapidemo.model.shixun.Borrowrecord;
import com.lin.appapidemo.model.shixun.Reader;
import com.lin.appapidemo.model.shixun.Subalbum;
import com.lin.appapidemo.util.DateTimeUtil;
import com.lin.appapidemo.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/excise")
public class ExciseController {
    @Autowired(required = false)
    private ReaderMapper readerMapper;
    @Autowired(required = false)
    private AlbumMapper albumMapper;
    @Autowired(required = false)
    private SubalbumMapper subalbumMapper;
    @Autowired(required = false)
    private BorrowrecordMapper borrowrecordMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestParam("account")String account,@RequestParam("password")String password){
        Map<String,Object> map=new HashMap<>();
        Reader reader=readerMapper.selectWholeByAccount(account);
        if(reader!=null){
            System.out.println("hahaha"+reader.getPassword().equals(password));
            if(reader.getPassword().equals(password)){
                System.out.println("hahaha"+reader.getPassword().equals(password));
                map.put("result","yes");
                map.put("loginUser",reader);
                if(reader.getCondi()==0){
                    map.put("condi",0);
                }else if(reader.getCondi()==1){
                    map.put("condi",1);
                }else{
                    map.put("condi",2);
                }
                return map;
            }
        }
        map.put("result","no");
        return map;
    }

    @RequestMapping(value = "/getAllReaders",method = RequestMethod.POST)
    public Map<String,Object> getAllReaders(@RequestParam("account")String account,@RequestParam("currentPage")int currentPage){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(currentPage,10);
        List<Reader> list=readerMapper.selectByAccount(account);
        PageInfo<Reader> pageInfo=new PageInfo<>(list);
        map.put("readers",list);
        map.put("pageInfo",pageInfo);
        return map;
    }

    @RequestMapping(value = "/getAllAlbums",method = RequestMethod.POST)
    public Map<String,Object> getAllAlbums(@RequestParam("title")String title,@RequestParam("currentPage")int currentPage){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(currentPage,10);
        List<Album> list=albumMapper.selectByTitle(title);
        PageInfo<Album> pageInfo=new PageInfo<>(list);
        map.put("pageInfo",pageInfo);
        map.put("albums",list);
        return map;
    }

    @RequestMapping(value = "/getAllBorrowRecords",method = RequestMethod.POST)
    public Map<String,Object> getAllBorrowRecords(@RequestParam("raccount")String raccount,@RequestParam("currentPage")int currentPage){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(currentPage,10);
        List<Borrowrecord> list=borrowrecordMapper.selectAllInfoByRaccount(raccount);
        PageInfo<Borrowrecord> pageInfo=new PageInfo<>(list);
        map.put("pageInfo",pageInfo);
        map.put("borrowrecords",list);
        return map;
    }

    @RequestMapping(value = "/addReader",method = RequestMethod.POST)
    public Map<String,Object> addReader(@RequestParam("account")String account,@RequestParam("name")String name,@RequestParam("sex")String sex,@RequestParam("condi")int condi){
        Map<String,Object> map=new HashMap<>();
        if(readerMapper.selectWholeByAccount(account)!=null){
            map.put("status","no");
        }else{
            readerMapper.insert(new Reader(account,account,name,sex, DateTimeUtil.getDate(),condi));
            map.put("status","ok");
        }
        return map;
    }
    @RequestMapping(value = "/addAlbum",method = RequestMethod.POST)
    public Map<String,Object> addAlbum(@RequestParam("title")String title,@RequestParam("author")String author,@RequestParam("publisher")String publisher,@RequestParam("publishtime")String publishtime,@RequestParam("descri")String descri){
        Map<String,Object> map=new HashMap<>();
        albumMapper.insert(new Album(title,author,publisher,publishtime,0,descri,DateTimeUtil.getDate()));
        map.put("status","ok");
        return map;
    }
    @RequestMapping(value = "/addSubAlbum",method = RequestMethod.POST)
    public Map<String,Object> addSubAlbum(@RequestParam("aid")int aid,@RequestParam("number")String number){
        Map<String,Object> map=new HashMap<>();
        if(subalbumMapper.selectByNumber(number)!=null){
            map.put("status","no");
        }else{
            Album album=albumMapper.selectById(aid);
            album.setNum(album.getNum()+1);
            albumMapper.updateByPrimaryKey(album);
            subalbumMapper.insert(new Subalbum(aid,number,0,DateTimeUtil.getDate()));
            map.put("status","ok");
        }
        return map;
    }
}
