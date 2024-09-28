package com.zt.tw_pom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zt.tw_pom.job.dao")
public class TwPomApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwPomApplication.class, args);
    }

}
