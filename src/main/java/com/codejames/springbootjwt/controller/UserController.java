package com.codejames.springbootjwt.controller;

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
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //登录
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
        return "你已通过验证";
    }
}
