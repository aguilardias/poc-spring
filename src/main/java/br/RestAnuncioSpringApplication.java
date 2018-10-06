package br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestAnuncioSpringApplication {

	public static void main(String[] args) {
		// evitar breakpoint em método SilentExitExceptionHandler.exitCurrentThread
		// quando inicia em modo debug
		// System.setProperty("spring.devtools.restart.enabled", "false");

		ConfigurableApplicationContext context = SpringApplication.run(RestAnuncioSpringApplication.class, args);

		// JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		// jmsTemplate.convertAndSend("destino", "mensagem1");
	}

	// @Bean
	// public JmsListenerContainerFactory<?> myFactory(ConnectionFactory
	// connectionFactory,
	// DefaultJmsListenerContainerFactoryConfigurer configurer) {
	// DefaultJmsListenerContainerFactory factory = new
	// DefaultJmsListenerContainerFactory();
	// configurer.configure(factory, connectionFactory);
	// return factory;
	// }
}
