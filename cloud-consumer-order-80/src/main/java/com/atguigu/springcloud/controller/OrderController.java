package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

   /* final private String URL="http://localhost:8001"*/; //这是单机版的写法
    final private String URL="http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/get/{id}")
    public CommonResult getPayment(@PathVariable long id){
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);
    }
}
