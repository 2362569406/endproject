package com.expressage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.expressage.dao")
public class WarehouseApp {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseApp.class,args);
    }
}
