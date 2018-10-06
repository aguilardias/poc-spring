package br.util;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class EnviarMensagemTibco {

	Logger logger = Logger.getLogger(EnviarMensagemTibco.class.getName());

	@Autowired
	JmsTemplate jmsTemplate;

	@Bean
	CommandLineRunner enviarMensagem() {
		return args -> {
			logger.info("enviarMensagem");
			jmsTemplate.convertAndSend("destino", "mensagem1");
			// Message receive = jmsTemplate.receive("destino");
			// System.out.println("recebido em: " + receive);
		};
	}
}
