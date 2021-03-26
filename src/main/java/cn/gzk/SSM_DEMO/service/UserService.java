package cn.gzk.SSM_DEMO.service;/*
 *ClassName:UserService
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

import cn.gzk.SSM_DEMO.model.entity.User;
import cn.gzk.SSM_DEMO.model.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface UserService {

    //将注册用户存入user表中
    int save(Map<String, String> userInfo);


    //通过电话和密码查找
    String findByPhoneAndPwd(String phone, String pwd);


    //通过id查找用户
    User findById(Integer id);

    //通过名字查找用户
    User findByName(String name);

    //通过手机号查找用户
    //User findByPhone(@Param("phone") String phone);

    //注册 使用userInfo<name,pwd>
    //JsonData register(@RequestBody Map<String, String> userInfo);

}
