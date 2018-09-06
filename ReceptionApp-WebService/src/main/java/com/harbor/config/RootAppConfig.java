package com.harbor.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value= {PersistanceConfig.class,ServiceConfig.class,WebSecurityConfig.class})
public class RootAppConfig {

	public static void main(String[] args) {
		SpringApplication.run(RootAppConfig.class, args);
	}
}
