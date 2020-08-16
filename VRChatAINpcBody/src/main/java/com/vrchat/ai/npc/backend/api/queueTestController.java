/**
  * @FileName : queueTestController.java
  * @Project : VRChatAiNpcBody
  * @Date : 2020. 4. 16. 
  * @작성자 : chp
  * @변경이력 :
  * @프로그램 설명 :
  */
package com.vrchat.ai.npc.backend.api;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chp
 *
 */
@RestController
@RequestMapping("/test/queue")
public class queueTestController {

	private final RabbitTemplate rabbitTemplate;
	private static final String EXCHANGE_NAME = "cafe.topic";

	public queueTestController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping("/default")
	public String testMessagePub() {

		rabbitTemplate.convertAndSend(EXCHANGE_NAME, "order.coffee.first", "Message");
		return "ok";

	}

	@GetMapping("/builder")
	public String testMessagePubByBuilder() {
		String carJson = "{\"keyword\" : \"nike\"}";

		Message message = MessageBuilder.withBody(carJson.getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON).build();

		rabbitTemplate.send(EXCHANGE_NAME, "order.coffee.a", message);
		
		return "ok";
	}
}
