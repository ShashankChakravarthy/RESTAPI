package com.example.RESTAPI.ReafactoredRESTAPI;

import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import com.example.RESTAPI.ReafactoredRESTAPI.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ReafactoredRestapiApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ReafactoredRestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product();
		product1.setDesc("First Product");
		product1.setName("First Product Desc");
		productRepo.save(product1);

		Product product2 = new Product();
		product2.setDesc("second Product");
		product2.setName("Second Product Desc");
		productRepo.save(product2);

	}

}

