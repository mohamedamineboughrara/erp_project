package com.example.Erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjetApplication.class, args);
	}

}
