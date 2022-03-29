package com.codejames.springbootjwt.config;

<<<<<<< HEAD
import com.codejames.springbootjwt.intercepter.AuthenticationInterceptor;
=======
import com.codejames.springbootjwt.intercepter.AuthenticationIntercepter;
>>>>>>> 6d7c11102ee496b88226c95d638374190fc717a8
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

<<<<<<< HEAD
    public AuthenticationInterceptor authenticationIntercepter(){
        return new AuthenticationInterceptor();
=======
    public AuthenticationIntercepter authenticationIntercepter(){
        return new AuthenticationIntercepter();
>>>>>>> 6d7c11102ee496b88226c95d638374190fc717a8
    }
}
