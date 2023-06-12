package com.example.Material;
import com.example.Material.Util.StorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MaterialApplication implements CommandLineRunner{
@Resource
StorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(MaterialApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//storageService.deleteAll();
		//storageService.init();

	}

}
