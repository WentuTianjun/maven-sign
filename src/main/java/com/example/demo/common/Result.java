package com.example.demo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("返回对象类型值")
    private T result;

    @ApiModelProperty("返回处理结果代码")
    private String code;

    @ApiModelProperty("返回处理提示信息")
    private String message;

    @ApiModelProperty("是否成功")
    private boolean success;

    private Result() {
        
    }
    
    private Result(T result, String code, String message, boolean success) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static <T> Result<T> ok() {
        return new Result<T>(null, null, null, true);
    }

    public static <T> Result<T> ok(T result) {
        return new Result<T>(result, null, null, true);
    }

    public static <T> Result<T> fail(String code, String message) {
        return new Result<T>(null, code, message, false);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>(null, "System error", message, false);
    }
}
