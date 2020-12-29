package com.ecommakeuproducts.jpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class MakeUpProductsApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MakeUpProductsApp.class, args);

	}

}
