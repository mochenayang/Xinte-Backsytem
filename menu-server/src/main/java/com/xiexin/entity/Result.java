package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result{
    private Integer status;
    private String message;
    private Object data;

    // 无data成功响应
    public static Result success(String msg){
        return new Result(200,msg,null);
    }

    // 有data成功响应
    public static Result success(String message,Object data){
        return new Result(200,message,data);
    }

    // 失败响应
    public static Result error(String msg){
        return new Result(500,msg,null);
    }
}
