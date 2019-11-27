package com.cun.security3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cun.security3.mapper")
public class Security3Application {

    public static void main(String[] args) {
        SpringApplication.run(Security3Application.class, args);
    }
}

