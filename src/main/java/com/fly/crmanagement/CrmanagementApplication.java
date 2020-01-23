package com.fly.crmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fly.crmanagement.dao")
public class CrmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmanagementApplication.class, args);
    }

}
