package com.nuist.medical.Constant;

public enum HttpCode {

    Http_OK(200);

    private Integer code;

    private HttpCode(Integer code){
        this.code=code;
    }

    public Integer getCode(){
        return code;
    }
}
