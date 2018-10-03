package br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestAnuncioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAnuncioSpringApplication.class, args);
	}
}
