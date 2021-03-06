package cn.gzk.SSM_DEMO.model.entity;/*
 *ClassName:User
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/*
* id	int
name	varchar
pwd	varchar
head_img	varchar
phone	varchar
create_time	datetime

* */
public class User {
    private Integer id;
    private String name;
    @JsonIgnore
    private String pwd;
    private String headImg;
    private String phone;
    private Date createTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
