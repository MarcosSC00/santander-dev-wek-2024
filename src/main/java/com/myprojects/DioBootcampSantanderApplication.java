package com.myprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/")})
public class DioBootcampSantanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioBootcampSantanderApplication.class, args);
	}

}
