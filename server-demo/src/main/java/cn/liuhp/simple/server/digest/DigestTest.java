package cn.liuhp.simple.server.digest;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * MD5数字摘要
 * */
public class DigestTest {


    public static void main(String[] args) {
        fun1();
        fun2();
    }


    /*
     * 通过jdk的工具得到MD5加密算法
     * */
    private static void fun1() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest("我是中国人".getBytes("UTF-8"));
            System.out.println(digest);
            System.out.println(bytesToHex(digest));
            System.out.println(hexToByte(bytesToHex(digest)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /*
     * 通过jdk的工具得到SHA-1加密算法
     * */
    private static void fun2() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] digest = messageDigest.digest("我是中国人".getBytes("UTF-8"));
            System.out.println(digest.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /*
     * 二进制转十六进制
     * */
    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }


    /*
    * 十六进制转二进制
    * */
    private static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }


    private static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

}
