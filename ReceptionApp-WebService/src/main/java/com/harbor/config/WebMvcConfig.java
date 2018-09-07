package com.harbor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"com.harbor.controller","com.harbor.filter"})
public class WebMvcConfig {

	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver CMRUupload() {
		CommonsMultipartResolver cmr=null;
	
		cmr=new CommonsMultipartResolver();
		cmr.setMaxUploadSize(2000000);	
		return cmr;
	}
}
