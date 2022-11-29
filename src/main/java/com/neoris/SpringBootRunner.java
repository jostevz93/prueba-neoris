package com.neoris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@SpringBootApplication
@EnableFeignClients
public class SpringBootRunner extends SpringBootServletInitializer
	implements WebApplicationInitializer, AsyncConfigurer {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner.class, args);
    }

}
