package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);

        if(i>0){
            log.info("服务器调用插入方法 成功："+i+"条");
            return new CommonResult(200, "插入数据成功 serverPort:"+serverPort, i);
        }else{
            log.info("服务器调用插入方法 失败："+i+"条");
            return new CommonResult(444, "插入数据失败 serverPort:"+serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable long id){
        Payment payment = paymentService.getPayment(id);
        if(payment !=null){
            log.info("获取数据成功："+payment);
            return new CommonResult(200,"获取数据成功 serverPort:"+serverPort,payment);
        }else{
            log.info("没有对应的数据");
            return new CommonResult(444,"没有对应的数据 serverPort:"+serverPort,null);
        }
    }
}
