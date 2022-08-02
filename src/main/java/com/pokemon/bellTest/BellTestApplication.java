package com.pokemon.bellTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BellTestApplication {


	public static void main(String[] args) {

		SpringApplication.run(BellTestApplication.class, args);

	}

}
