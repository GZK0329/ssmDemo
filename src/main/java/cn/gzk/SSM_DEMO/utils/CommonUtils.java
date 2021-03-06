package cn.gzk.SSM_DEMO.utils;/*
 *ClassName:CommonUtils
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

import java.security.MessageDigest;

public class CommonUtils {

    //MD5加密工具类
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) |
                        0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
