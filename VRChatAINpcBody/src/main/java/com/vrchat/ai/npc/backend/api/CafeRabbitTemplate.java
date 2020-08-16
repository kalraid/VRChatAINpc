/**
  * @FileName : CafeRabbitTemplate.java
  * @Project : VRChatAiNpcBody
  * @Date : 2020. 4. 16. 
  * @작성자 : chp
  * @변경이력 :
  * @프로그램 설명 :
  */
package com.vrchat.ai.npc.backend.api;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

/**
 * @author chp
 *
 */
public class CafeRabbitTemplate {

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionfactory, MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionfactory);
		rabbitTemplate.setMessageConverter(messageConverter);

		return rabbitTemplate;
	}

	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
