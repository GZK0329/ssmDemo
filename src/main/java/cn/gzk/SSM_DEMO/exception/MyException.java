package cn.gzk.SSM_DEMO.exception;/*
 *ClassName:MyException
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

//自定义异常类
public class MyException extends RuntimeException{
    private Integer code;
    private String msg;

    public MyException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
