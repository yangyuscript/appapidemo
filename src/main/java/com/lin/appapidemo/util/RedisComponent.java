package com.lin.appapidemo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class RedisComponent {
    //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private Logger logger= LoggerFactory.getLogger(RedisComponent.class);
    //RedisTemplate可以进行所有的操作
    @Autowired(required = false)
    private RedisTemplate<Object,Object> redisTemplate;
    public void set(String key,String value){
        ValueOperations<String,String> ops=this.stringRedisTemplate.opsForValue();
        boolean bExistent=this.stringRedisTemplate.hasKey(key);
        if(bExistent){
            logger.info("this key is bExistent!");
        }else{
            ops.set(key,value);
        }
    }
    public String get(String key){
        return this.stringRedisTemplate.opsForValue().get(key);
    }
    public void del(String key){
        this.stringRedisTemplate.delete(key);
    }

    public void sentinelSet(String key,Object object){
        redisTemplate.opsForValue().set(key,object,180, TimeUnit.SECONDS);
    }
    public Object sentinelGet(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void setLongExpire(String key){
        //设置token一星期过期
        redisTemplate.expire(key,60*60*24*7,TimeUnit.SECONDS);
    }
}
