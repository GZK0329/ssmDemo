package cn.gzk.SSM_DEMO.service.impl;/*
 *ClassName:UserServiceImpl
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

import cn.gzk.SSM_DEMO.model.entity.User;
import cn.gzk.SSM_DEMO.mapper.UserMapper;
import cn.gzk.SSM_DEMO.service.UserService;
import cn.gzk.SSM_DEMO.utils.CommonUtils;
import cn.gzk.SSM_DEMO.utils.JWTUtils;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if(user == null){
            return null;
        }else{
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    @Override
    public int save(Map<String, String> userInfo) {
            User user = parseToUser(userInfo);
            if(user != null){
                return userMapper.save(user);
            }else {
                return -1;
            }
    }

    private User parseToUser(Map<String, String> userInfo) {
        User user = new User();
        if(userInfo.containsKey("phone") && userInfo.containsKey("name") && userInfo.containsKey("pwd")){
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(getRandomImg());
            user.setName(userInfo.get("name"));
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }
            return null;
    }

    /*@Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }*/

    /*@Override
    public JsonData register(Map<String, String> userInfo) {
       return userMapper.register(userInfo);
    }*/

    //随机头像生成
    public static final String[] headImg = {
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    //获取随机头像
    public String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
