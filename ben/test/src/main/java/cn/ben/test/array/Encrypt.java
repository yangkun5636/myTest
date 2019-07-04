package cn.ben.test.array;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

/**
 * @author yangkun
 * @see
 * @since
 */
public class Encrypt {

    public static void main(String[] args) throws Exception {
        rsa();
    }

    private static void base64() {
        String value = "ILOVEXUANXUAN";
        String encode = encode(value);
        System.out.println("加密后的字符串:" + encode);
        String decode = decode(encode);
        System.out.println("解密后的字符串:" + decode);
    }

    private static String decode(String str) {
        byte[] decode = Base64.decodeBase64(str);
        return new String(decode);
    }

    private static String encode(String str) {
        byte[] encode = Base64.encodeBase64(str.getBytes());
        return new String(encode);
    }


    private static void rsa() throws Exception {
        Map<String, String> map = genKeyPair();
        String value = "ILOVEXUANXUAN";
        System.out.println(map);
        String encode = encode(value, map.get("public"));
        System.out.println(encode);
        String decode = decode(value, map.get("private"));
        System.out.println(decode);

    }

    private static Map<String, String> genKeyPair() throws NoSuchAlgorithmException {
        //基于RAS生成对象
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(512);
        KeyPair keyPair = generator.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        Map<String, String> map = new HashMap<>();
        map.put("private", new String(Base64.encodeBase64(privateKey.getEncoded())));
        map.put("public", new String(Base64.encodeBase64(publicKey.getEncoded())));
        return map;
    }

    private static String encode(String value, String publicKey) throws Exception {
        byte[] bytes = Base64.decodeBase64(publicKey);
        Cipher cipher = Cipher.getInstance("RSA");
        Key key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes1 = cipher.doFinal(value.getBytes());
        String s = Base64.encodeBase64String(bytes1);
        return s;
    }

    private static String decode(String value, String privateKey) throws Exception {
        byte[] bytes = Base64.decodeBase64(value.getBytes("UTF-8"));
        byte[] bytes1 = Base64.decodeBase64(privateKey);
        Cipher cipher = Cipher.getInstance("RSA");
        Key key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes1));
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(bytes));
    }

}
