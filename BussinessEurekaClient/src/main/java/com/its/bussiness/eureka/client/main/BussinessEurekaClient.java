package com.its.bussiness.eureka.client.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tuannx2
 *
 */
@EnableEurekaClient
@ComponentScan("com.its.bussiness.*")
@EnableAutoConfiguration
@SpringBootApplication
public class BussinessEurekaClient {
	public static void main(String[] args) {
		SpringApplication.run(BussinessEurekaClient.class, "");
	}
}
