package com.skynet.skynet_po_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.skynet.skynet_po_api.job.dao")
public class SkynetPoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkynetPoApiApplication.class, args);
    }

}
