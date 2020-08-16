package com.vrchat.ai.npc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VrChatAiNpcMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrChatAiNpcMainApplication.class, args);
	}

}
