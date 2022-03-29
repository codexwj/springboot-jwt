package com.codejames.springbootjwt.exception;

import lombok.Data;


public enum JwtExceptionCode {

    TOKEN_ERROR("11001", "Token错误");


    private String code;
    private String message;

    JwtExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
