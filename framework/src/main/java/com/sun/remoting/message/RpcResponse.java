package com.sun.remoting.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcResponse<T> implements Serializable {
    //响应码
    private Integer statusCode;
    //响应状态信息(长连接)
    private String message;
    //响应数据
    private T data;

    public static <T> RpcResponse<T> success(T data){
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(T data){
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.FAIL.getCode());
        //response.setData(data);
        return response;
    }
}


enum ResponseCode {
    SUCCESS(0),
    FAIL(1);
    private final Integer code;

    ResponseCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

