package com.yan.lottery.common;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -7516927070721018007L;
    private String code;
    private String info;

    public static Result buildResult(String code, String info){
        return new Result(code, info);
    }

    public static Result buildSuccessResult(){
        return new Result(Contants.ResponseCode.SUCCESS.getCode(), Contants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildErrorResult(){
        return new Result(Contants.ResponseCode.UN_ERROR.getCode(), Contants.ResponseCode.UN_ERROR.getInfo());
    }

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
