package com.its.register.eureka.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tuannx2
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.its.register.*")
@EnableEurekaServer
public class RegisterEurekaServerBootApp {
	public static void main(String[] args) {
		SpringApplication.run(RegisterEurekaServerBootApp.class, "");
	}
}
