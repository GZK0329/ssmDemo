package cn.gzk.SSM_DEMO.controller;
/*
 *ClassName:UserController
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

import cn.gzk.SSM_DEMO.model.request.LoginRequest;
import cn.gzk.SSM_DEMO.service.UserService;
import cn.gzk.SSM_DEMO.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){
            int rows = userService.save(userInfo);
            return rows == 1 ? JsonData.buildSuccess():JsonData.buildError("注册异常");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("异常 登陆失败"):JsonData.buildSuccess(token);
    }


    @PostMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){

        Integer id = (Integer) request.getAttribute("id");
        System.out.println("id="+id);
        String name = (String) request.getAttribute("name");
        System.out.println("name="+name);
        if(id != null){
            return JsonData.buildSuccess(userService.findById(id));
        }else if(name != null){
            return JsonData.buildSuccess(userService.findByName(name));
        }else{
            return JsonData.buildError("出错了 controller层");
        }
    }

    /*@GetMapping("findByPhone")
    public User findByPhone(@RequestBody String phone){
        try{
            return userService.findByPhone(phone);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("按手机号查找用户 异常==========");
        }
    }*/

    /*@GetMapping("insertUser")
    public int save(@RequestBody Map<String, String> userInfo){
        try {
             return userService.save(userInfo);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("插入用户异常===========");
            return -1;
        }
    }*/

}
