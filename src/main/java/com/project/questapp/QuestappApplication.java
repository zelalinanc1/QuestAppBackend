package com.project.questapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication

//@ComponentScan(basePackages = {"com.baeldung.dependency.exception"})
public class QuestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestappApplication.class, args);
	}

}
