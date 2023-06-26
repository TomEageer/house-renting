package com.qf.hose.renting.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncoder {

    public static String encode(String rawPass){
        try {
            //获取MD5加密算法的实例
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //加密
            byte[] result = md5.digest(rawPass.getBytes());
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException e) {
        }
        return "";
    }
}
