
package com.baidu.mapp.bcd.common.utils.digest;

import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

public class AESUtil {

	/**
	 * 密钥算法
	 */
	private static final String KEY_ALGORITHM = "AES";

	/**
	 * 加密/解密算法 / 工作模式 / 填充方式
	 * Java 6支持PKCS5Padding填充方式
	 * Bouncy Castle支持PKCS7Padding填充方式
	 */
	private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

	/**
	 * 偏移量，只有CBC模式才需要
	 */
	private final static String ivParameter = "0000000000000000";

	/**
	 * AES要求密钥长度为128位或192位或256位，java默认限制AES密钥长度最多128位
	 */
	public static String key="eLeJynWJ9WEOT5YCP3uFM3MASKYmgogN" ;

	/**
	 * 编码格式
	 */
	public static final String ENCODING = "utf-8";


	static {
		//如果是PKCS7Padding填充方式，则必须加上下面这行
		Security.addProvider(getProvider());
	}
	private static Provider provider;
	public static Provider getProvider() {
		if (provider == null) {
			try{
				Class<?> pclass = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
				Object o = pclass.newInstance();
				provider = (Provider) o;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return provider;
	}
	/**
	 * AES加密
	 * @param source	源字符串
	 * @return	加密后的密文
	 * @throws Exception
	 */
	public static String encrypt(String source) throws Exception {
		byte[] sourceBytes = source.getBytes(ENCODING);
		byte[] keyBytes = key.getBytes(ENCODING);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(ENCODING));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, KEY_ALGORITHM),iv);
        byte[] decrypted = cipher.doFinal(sourceBytes);
        return Base64.encodeBase64String(decrypted);
	}

	/**
	 * AES解密
	 * @param encryptStr	加密后的密文
	 * @return	源字符串
	 * @throws Exception
	 */
	public static String decrypt(String encryptStr) throws Exception {
		byte[] sourceBytes = Base64.decodeBase64(encryptStr);
		byte[] keyBytes = key.getBytes(ENCODING);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(ENCODING));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, KEY_ALGORITHM),iv);
        byte[] decoded = cipher.doFinal(sourceBytes);
        return new String(decoded, ENCODING);
	}


	public static void main(String[] args) throws Exception {
		String str = RandomStringUtils.randomAlphanumeric(32);
		System.out.println(str);

		String encrypt = encrypt("1234");
		System.out.println(encrypt);

		String decode = decrypt(encrypt);

		System.out.println(decode);
	}

}
