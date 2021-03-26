package cn.gzk.SSM_DEMO.utils;/*
 *ClassName:JsonData
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

public class JsonData {
    //状态码 0成功 1正在处理 -1表示失败

    private Integer code;

    //业务数据
    private Object data;

    //信息描述
    private String msg;

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonData(String msg, Object data) {
        this.data = data;
        this.msg = msg;
    }

    public JsonData(String msg) {
        this.msg = msg;
    }

    public static JsonData buildSuccess(){
        return new JsonData(0, null, null);
    }
    public static JsonData buildSuccess(Object data){
        return new JsonData(0, data, null);
    }
    public static JsonData buildSuccess(String msg){
        return new JsonData(msg);
    }

    public static JsonData buildError(String msg){
        return new JsonData(-1, null, msg);
    }
    public static JsonData buildError(Integer code){
        return new JsonData(code, null, null);
    }
    public static JsonData buildError(Integer code,String msg){
        return new JsonData(code, null, msg);
    }
    public static JsonData buildError(String msg,Object data){
        return new JsonData(msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
