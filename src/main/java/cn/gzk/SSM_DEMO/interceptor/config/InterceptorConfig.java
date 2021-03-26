package cn.gzk.SSM_DEMO.interceptor.config;
/*
 *ClassName:InterceptorConfig
 *Description:
 *Author: GZK0329
 *Date: 2021/3/25
 */

import cn.gzk.SSM_DEMO.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/api/v1/pri/*/*/**")
                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
