package com.smart.classroom.application;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.smart.classroom.repository.StaffRepository;

@EnableJms
@ComponentScan(basePackages = "com.smart.classroom")
@EntityScan(basePackages = "com.smart.classroom.model")
@EnableJpaRepositories(basePackageClasses = StaffRepository.class)
@SpringBootApplication
public class ClassroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassroomApplication.class, args);
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsConFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		factory.setErrorHandler(e -> e.printStackTrace());

		configurer.configure(factory, connectionFactory);

		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
