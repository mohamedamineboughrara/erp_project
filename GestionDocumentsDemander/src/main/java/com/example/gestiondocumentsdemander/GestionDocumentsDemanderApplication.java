package com.example.gestiondocumentsdemander;

import com.example.gestiondocumentsdemander.utils.StorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionDocumentsDemanderApplication implements CommandLineRunner

{
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(GestionDocumentsDemanderApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//storageService.deleteAll();
		//storageService.init();

	}

}
