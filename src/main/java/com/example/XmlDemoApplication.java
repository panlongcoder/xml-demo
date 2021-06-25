package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.example.mapper")
@EnableScheduling
@SpringBootApplication
public class XmlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlDemoApplication.class, args);
    }

}
