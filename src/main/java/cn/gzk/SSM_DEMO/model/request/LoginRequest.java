package cn.gzk.SSM_DEMO.model.request;/*
 *ClassName:LoginRequest
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

public class LoginRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
