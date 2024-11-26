package com.example.TDE4av2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		servers = {
				@Server(url = "/", description = "Default Server URL")
		}
)
@SpringBootApplication
public class Tde4av2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tde4av2Application.class, args);
	}

}
