package com.its.web.thymeleaf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author itshare
 *
 */
@EnableAutoConfiguration
@ComponentScan("com.its.web.*")
@SpringBootApplication
public class ITSWebThymeleafBootApp {
	public static void main(String[] args) {
		SpringApplication.run(ITSWebThymeleafBootApp.class, "");
	}
}
