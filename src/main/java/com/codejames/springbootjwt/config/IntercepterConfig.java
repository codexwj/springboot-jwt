package com.codejames.springbootjwt.config;

import com.codejames.springbootjwt.intercepter.AuthenticationIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationIntercepter())
                .addPathPatterns("/**"); // 拦截所有的请求
    }

    public AuthenticationIntercepter authenticationIntercepter(){
        return new AuthenticationIntercepter();
    }
}
