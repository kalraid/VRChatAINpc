/**
  * @FileName : CafeMessageListener.java
  * @Project : VRChatAiNpcMain
  * @Date : 2020. 4. 16. 
  * @작성자 : chp
  * @변경이력 :
  * @프로그램 설명 :
  */
package com.vrchat.ai.npc.backend.api;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chp
 *
 */
@Component
public class CafeMessageListener {

	@RabbitListener(queues = "coffee.queue")
	public void receviveMessage(final Message message) {
		System.out.println(message);
	}
}
