package com.etiya.northwind;

import org.springframework.boot.SpringApplication;


@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	// Bir ürün bizim projemize dahil edilirken pomXmle dependencyleri ekledikten sonra runApplicationa
	// Bean configurasyonunu ve başlatma anotasyonunu eklememiz lazım

}
