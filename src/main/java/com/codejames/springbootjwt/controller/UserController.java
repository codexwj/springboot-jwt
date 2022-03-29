package com.codejames.springbootjwt.controller;

<<<<<<< HEAD
import com.auth0.jwt.JWT;
import com.codejames.springbootjwt.config.UserLoginToken;
import com.codejames.springbootjwt.entity.User;
import com.codejames.springbootjwt.service.impl.UserServiceImpl;
import com.codejames.springbootjwt.utils.JwtUtil;
import com.codejames.springbootjwt.utils.JwtUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
=======
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
>>>>>>> 6d7c11102ee496b88226c95d638374190fc717a8
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //登录
<<<<<<< HEAD
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map login(@RequestBody User user) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        User userForBase = userService.findByUsername(user.getUsername());
        if (userForBase == null) {
            map.put("message", "登录失败,用户不存在");
            return map;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                map.put("message", "登录失败,密码错误");
                return map;
            } else {
//                String token = JwtUtils.getToken(userForBase);
                String token = JwtUtil.genJsonWebToken(userForBase.getId());
                map.put("token", token);
                map.put("user", userForBase);
                return map;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
=======
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
>>>>>>> 6d7c11102ee496b88226c95d638374190fc717a8
        return "你已通过验证";
    }
}
