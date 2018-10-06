package br.config;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tibco.tibjms.TibjmsConnectionFactory;

@Configuration
public class MinhaConnectionFactory {

	private static final String JMS_URL = "url-teste";
	private static final String USERNAME = "usuario1";
	private static final String PASSWORD = "senha1";

	// @Bean
	// public TibjmsConnectionFactory connectionFactory() {
	//
	// TibjmsConnectionFactory connectionFactory = new
	// TibjmsConnectionFactory(JMS_URL);
	// connectionFactory.setUserName(USERNAME);
	// connectionFactory.setUserPassword(PASSWORD);
	//
	// return connectionFactory;
	// }

	@Bean
	public ConnectionFactory connectionFactory() {

		TibjmsConnectionFactory connectionFactory = new TibjmsConnectionFactory(JMS_URL);
		connectionFactory.setUserName(USERNAME);
		connectionFactory.setUserPassword(PASSWORD);

		return connectionFactory;
	}
}
