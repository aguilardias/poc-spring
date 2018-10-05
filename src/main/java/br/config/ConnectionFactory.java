package br.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tibco.tibjms.TibjmsConnectionFactory;

@Configuration
public class ConnectionFactory {

	private static final String JMS_URL = null;
	private static final String USERNAME = null;
	private static final String PASSWORD = null;

	@Bean
	public TibjmsConnectionFactory connectionFactory() {

		TibjmsConnectionFactory connectionFactory = new TibjmsConnectionFactory(JMS_URL);
		connectionFactory.setUserName(USERNAME);
		connectionFactory.setUserPassword(PASSWORD);

		return connectionFactory;
	}
}
