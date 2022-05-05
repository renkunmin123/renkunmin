package com.tm.utils;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String massage;
    private T data;

    public Result() {
        this.code = ResultCode.SUCCESS.getCode();
        this.massage = ResultCode.SUCCESS.getMessage();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.massage = resultCode.getMessage();
        this.data = data;
    }
    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.massage = resultCode.getMessage();
        this.data = data;
    }
    public static Result success(Object data){

        return  new Result(ResultCode.SUCCESS,data);
    }
    public static Result success(){

        return success(null);
    }
    public static Result error(Object data){

        return new Result(ResultCode.ERROR,data);
    }
    public static Result error(){

        return error(null);
    }
}