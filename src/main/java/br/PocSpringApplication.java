package br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class PocSpringApplication {

	public static void main(String[] args) {
		// evitar breakpoint em método SilentExitExceptionHandler.exitCurrentThread
		// quando inicia em modo debug
		// System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(PocSpringApplication.class, args);
	}

}
