package com.harbor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.harbor.controller","com.harbor.filter"})
public class WebMvcConfig {

}
