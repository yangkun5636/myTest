package com.ben.shiro.util;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.H64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加解密工具类
 *
 * @author yangkun
 */
public class EncryptUtils {

    /**
     * 默认加密次数
     */
    private static final Integer DEFAULT_ITERATIONS = 1;

    /**
     * Shiro的MD5加密，加密方式是对字符串salt+password进行加密
     */
    public static String shiroMd5(String salt, String password) {
        String algorithmName = "MD5";
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, byteSalt, DEFAULT_ITERATIONS);
        return simpleHash.toHex();
    }

    /**
     * Java的MD5加密，加密方式是对字符串salt+password进行加密
     */
    public static String md5(String salt, String password) {
        StringBuilder result = new StringBuilder();
        byte[] bytes;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 对字符串进行加密
            md.update((salt + password).getBytes());
            // 获得加密后的数据
            bytes = md.digest();

            // 将加密后的数据转换为16进制数字
            result.append(new BigInteger(1, bytes).toString(16));
            // 如果生成数字未满32位，需要前面补0
            for (int i = 0; i < 32 - result.length(); i++) {
                result.insert(0, "0");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        return result.toString();
    }

    public static void main(String[] args) {

//        String password1 = shiroMd5("admin", "12345678");
//        System.out.println(password1);

//        String password2 = md5("admin", "12345678");
//        System.out.println(password2);

        // 两者加密结果相同
//        System.out.println(password1.equals(password2));
        Sha256Hash();
        SimpleHash();
    }

    public static void base64() {
        String name = Base64.encodeToString("chenzhitao".getBytes());
        System.out.println(name);
        System.out.println(Base64.decodeToString(name));
    }

    public static void hex() {
        String name = Hex.encodeToString("chenzhitao".getBytes());
        System.out.println(name);
        System.out.println(new String(Hex.decode(name)));
    }

    public static void h64() {
        System.out.println(H64.encodeToString("chenzhitao".getBytes()));
    }

    public static void Md5Hash() {
        System.out.println(new Md5Hash("chenzhitao", "666"));
        System.out.println(new Md5Hash("chenzhitao"));
        System.out.println(new Md5Hash("chenzhitao", "2"));
        System.out.println(new Md5Hash("chenzhitao", "2", 2));
    }

    public static void Sha256Hash() {
        System.out.println(new Sha1Hash("chenzhitao"));
        System.out.println(new Sha1Hash("chenzhitao", "666"));
        System.out.println(new Sha256Hash("chenzhitao"));
        System.out.println(new Sha256Hash("chenzhitao", "666"));
        System.out.println(new Sha384Hash("chenzhitao"));
        System.out.println(new Sha384Hash("chenzhitao", "666").toString().length());
    }

    public static void SimpleHash() {
        System.out.println(new SimpleHash("SHA-512", "chenzhitao", "666", 1));

    }
}