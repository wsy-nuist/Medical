package com.nuist.medical.Constant;

public enum HttpCode {

    Http_OK(200),
    INTERNAL_ERROR(500),
    INVALIDATE_TOKEN(-1);
    private Integer code;

    private HttpCode(Integer code){
        this.code=code;
    }

    public Integer getCode(){
        return code;
    }
}
