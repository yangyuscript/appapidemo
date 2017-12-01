package com.lin.appapidemo.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String EncodeByMD5(String str) throws NoSuchAlgorithmException,UnsupportedEncodingException{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String newStr=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}
