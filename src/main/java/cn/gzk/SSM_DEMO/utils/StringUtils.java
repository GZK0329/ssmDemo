package cn.gzk.SSM_DEMO.utils;/*
 *ClassName:StringUtils
 *Description:
 *Author: GZK0329
 *Date: 2021/3/25
 */

public class StringUtils {
    public static boolean isNotBlank(String s){
        if(s == " "){
            return false;
        }else{
            return true;
        }
    }
}
