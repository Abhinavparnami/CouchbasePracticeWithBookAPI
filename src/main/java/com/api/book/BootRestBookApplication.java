package com.api.book;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition
public class BootRestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestBookApplication.class, args);
	}

}
