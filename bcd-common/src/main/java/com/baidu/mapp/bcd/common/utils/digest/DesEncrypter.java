package com.baidu.mapp.bcd.common.utils.digest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * DES对称加密工具类
 */
public class DesEncrypter {

    private String slat;

    DesEncrypter(String slat) {
        this.slat = slat;
    }

    /**
     * 对称加密
     *
     * @param source
     * @return
     */
    public byte[] encrypt(byte[] source) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, genSecretKey());
        byte[] bytes = cipher.doFinal(source);
        return Base64.encodeBase64(bytes);
    }

    /**
     * 解密
     *
     * @param source
     * @return
     */
    public byte[] decrypt(byte[] source) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, genSecretKey());
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(source));
        return bytes;
    }

    /**
     * 通过盐生成SecretKey对象
     */
    private SecretKey genSecretKey() throws Exception {
        DESKeySpec desKey = new DESKeySpec(slat.getBytes());
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

}
