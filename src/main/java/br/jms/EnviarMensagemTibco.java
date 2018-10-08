package br.jms;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class EnviarMensagemTibco {

	@Value("${app.jms.fila.envio}")
	private String FILA_DESTINO;

	Logger logger = Logger.getLogger(EnviarMensagemTibco.class.getName());

	@Autowired
	JmsTemplate jmsTemplate;

	@Bean
	CommandLineRunner enviarMensagem() {
		return args -> {
			logger.info("enviarMensagem");
			jmsTemplate.convertAndSend(FILA_DESTINO, "mensagem1");

			// Message receive = jmsTemplate.receive("destino");
			// System.out.println("recebido em: " + receive);
		};
	}
}
