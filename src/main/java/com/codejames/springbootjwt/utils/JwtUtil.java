package com.codejames.springbootjwt.utils;


import com.codejames.springbootjwt.exception.JwtExceptionCode;
import io.jsonwebtoken.*;

import java.util.Date;


/**
 * jwt工具类
 */
public class JwtUtil {
	 /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法  
     *
     * @param ttlMillis jwt过期时间
     * @param user      登录成功的user对象
     * @return
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;  //token过期时间，毫秒，1天
    public static final String SIGNSECRET = "CAiq7wSrEDDDfGShQWX9lM6oeJcoKrgvKWnutKy7I"; //签名秘钥，服务端的私钥
    /**
     * 生成jwt token
     * @param userId
     * @return
     */
    public static String genJsonWebToken(String userId) {
        String token = Jwts.builder().setSubject(userId)
        		.claim("userId", userId)
                .setIssuedAt(new Date()) //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SIGNSECRET).compact();
        return token;
    }
    
  //不管是否过期，都返回claims对象
    public static Claims parseJwt(String token) throws Exception{
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SIGNSECRET) // 设置标识名
                    .parseClaimsJws(token)  //解析token
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }catch (SignatureException e) {
        	throw new Exception(String.valueOf(JwtExceptionCode.TOKEN_ERROR));
		}
        return claims;
    }
    
    /**
     * 校验jwt token
     * @param token
     * @return
     * @throws Exception
     */
    public static Boolean isVerify(String token) throws Exception {
      //不管是否过期，都返回claims对象
        Claims claims = JwtUtil.parseJwt(token);
        Date expiration = claims.getExpiration();
        //和当前时间进行对比来判断是否过期
        return new Date(System.currentTimeMillis()).after(expiration);
    }
    
    /**
     * 获取 userId
     * @param token
     * @return
     * @throws Exception
     */
    public static String getUserId(String token) throws Exception {
    	Claims claims = JwtUtil.parseJwt(token);
        return (String)claims.get("userId");
    }

    public static void main(String[] args) {
        String s = genJsonWebToken("1");
        System.out.println(s);
    }
}
    
    
    
    
    
    
    
    
	
	

