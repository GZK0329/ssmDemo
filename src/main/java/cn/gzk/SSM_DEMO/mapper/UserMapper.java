package cn.gzk.SSM_DEMO.mapper;
/*
 *ClassName:UserMapper
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

import cn.gzk.SSM_DEMO.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //保存已注册用户
    int save(User user);

    //通过手机号查找用户
    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findById(Integer id);

    User findByName(String name);

    /*//通过token解密个人信息从而通过数据库查询个人信息
    User findByToken(@Param("token") String token);*/
    //注册
    //JsonData register(@RequestBody Map<String, String> userInfo);
}
