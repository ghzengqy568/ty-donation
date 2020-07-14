/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.common.utils.digest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Digest {

    private static Map<String, Digest> slatMap = new ConcurrentHashMap<>();

    private String slat;

    private DesEncrypter desEncrypter;

    private Digest(){}

    public static Digest getInstance(String slat) {
        Digest digest = slatMap.get(slat);
        if (digest == null) {
            digest = new Digest();
            DesEncrypter desEncrypter = new DesEncrypter(slat);
            digest.desEncrypter = desEncrypter;
            slatMap.put(slat, digest);
        }
        return digest;
    }

    /**
     * 对字符串md5加密
     * @return
     */
    public static String genMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误", e);
        }
    }

    /**
     * 对字符流md5加密
     * @return
     */
    public static String genMD5(byte[] source) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(source);
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误", e);
        }
    }

    public String encryptDes(String source) throws Exception {
        byte[] encrypt = desEncrypter.encrypt(source.getBytes());
        return new String(encrypt);
    }

    public String decryptDes(String source) throws Exception {
        byte[] encrypt = desEncrypter.decrypt(source.getBytes());
        return new String(encrypt);
    }


}
