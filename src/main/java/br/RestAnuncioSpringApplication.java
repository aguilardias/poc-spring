package br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestAnuncioSpringApplication {

	public static void main(String[] args) {
		// evitar breakpoint em método SilentExitExceptionHandler.exitCurrentThread
		// quando inicia em modo debug
		// System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(RestAnuncioSpringApplication.class, args);
	}

}
