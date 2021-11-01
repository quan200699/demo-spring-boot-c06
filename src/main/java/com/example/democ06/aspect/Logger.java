package com.example.democ06.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @AfterThrowing("execution(public * com.example.democ06.service.product.ProductService.save(..))")
    public void log() {
        System.out.println("Đây là ghi log lỗi");
    }
}
