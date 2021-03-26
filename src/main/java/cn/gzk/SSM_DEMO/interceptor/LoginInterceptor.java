package cn.gzk.SSM_DEMO.interceptor;/*
 *ClassName:LoginInterceptor
 *Description:
 *Author: GZK0329
 *Date: 2021/3/25
 */

import cn.gzk.SSM_DEMO.utils.JWTUtils;
import cn.gzk.SSM_DEMO.utils.JsonData;
import cn.gzk.SSM_DEMO.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String accessToken = request.getHeader("token");
            if(accessToken == null){
                accessToken = request.getParameter("token");
            }
            if(StringUtils.isNotBlank(accessToken)){
                Claims claims = JWTUtils.checkJWT(accessToken);
                if(claims == null){
                    //空 登陆信息过期
                    sendJsonMessage(response, JsonData.buildError("登陆失效，重新登陆"));
                    //System.out.println("登陆失败==============");
                }else{
                    Integer id = (Integer) claims.get("id");
                    System.out.println("拦截器中id="+id);
                    String name = (String) claims.get("name");
                    System.out.println("拦截器中name="+name);
                    request.setAttribute("id", id);
                    request.setAttribute("name", name);
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            sendJsonMessage(response, JsonData.buildError("登陆失效，重新登陆"));
        }
        return false;
    }

    public static void sendJsonMessage(HttpServletResponse response, Object obj){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
