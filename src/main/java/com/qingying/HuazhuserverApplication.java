package com.qingying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.qingying.*.mapper"})
public class HuazhuserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuazhuserverApplication.class, args);
    }

}
