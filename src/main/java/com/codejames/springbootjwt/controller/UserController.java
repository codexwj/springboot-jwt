package com.codejames.springbootjwt.controller;

import com.codejames.springbootjwt.config.UserLoginToken;
import com.codejames.springbootjwt.entity.User;
import com.codejames.springbootjwt.service.impl.UserServiceImpl;
import com.codejames.springbootjwt.utils.JwtUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //登录
    @PostMapping("/login")
    public Object login( User user) throws Exception{
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user.getUsername());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = JwtUtils.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
