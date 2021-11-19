package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer id;
    private String message;
    private T       data;
    public CommonResult(Integer id,String message){
        this(id,message,null);
    }
}
