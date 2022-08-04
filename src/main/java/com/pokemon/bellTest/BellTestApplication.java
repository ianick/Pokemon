package com.pokemon.bellTest;

import com.pokemon.bellTest.Client.PokemonResponse;
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
