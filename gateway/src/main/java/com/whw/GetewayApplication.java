package com.whw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: management
 * @ClassName GetewayApplication
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-10 17:41
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GetewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetewayApplication.class,args);
    }
}
