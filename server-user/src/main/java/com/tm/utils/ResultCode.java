package com.tm.utils;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(2000,"操作成功"),
    ERROR(5000,"操作失败");

    private Integer Code;
    private String message;

    ResultCode(Integer code, String message) {
        Code = code;
        this.message = message;
    }
}