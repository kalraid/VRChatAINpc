/**
  * @FileName : RabbitConfig.java
  * @Project : VRChatAiNpcMain
  * @Date : 2020. 4. 16. 
  * @작성자 : chp
  * @변경이력 :
  * @프로그램 설명 :
  */
package com.vrchat.ai.npc.config.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chp
 *
 */
@Configuration
public class RabbitConfig {

	private static final String EXCHANGE_NAME = "cafe.topic";
	private static final String QUEUE_NAME = "coffee.queue";
	private static final String ROUTING_KEY = "order.coffee.#";
	
	
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
}
