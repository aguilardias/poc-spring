package br.config.jms;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tibco.tibjms.TibjmsQueueConnectionFactory;

@Configuration
public class TibcoConnectionFactory {

	@Value("${app.jms.url}")
	private String JMS_URL;

	@Value("${app.jms.username}")
	private String USERNAME;

	@Value("${app.jms.password}")
	private String PASSWORD;

	@Bean
	public ConnectionFactory connectionFactory() {

		TibjmsQueueConnectionFactory connectionFactory = new TibjmsQueueConnectionFactory(JMS_URL);
		connectionFactory.setUserName(USERNAME);
		connectionFactory.setUserPassword(PASSWORD);

		return connectionFactory;
	}

	// Serialize message content to json using TextMessage
	// @Bean
	// public MessageConverter jacksonJmsMessageConverter() {
	// MappingJackson2MessageConverter converter = new
	// MappingJackson2MessageConverter();
	// converter.setTargetType(MessageType.BYTES);
	// converter.setTypeIdPropertyName("_type");
	// return converter;
	// }

	// @Bean
	// public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	// DefaultJmsListenerContainerFactory factory = new
	// DefaultJmsListenerContainerFactory();
	// factory.setConnectionFactory(connectionFactory());
	// factory.setConcurrency("1");
	// factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
	//
	// return factory;
	// }
}
