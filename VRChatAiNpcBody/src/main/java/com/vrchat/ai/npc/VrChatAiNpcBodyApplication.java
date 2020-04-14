package com.vrchat.ai.npc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VrChatAiNpcBodyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrChatAiNpcBodyApplication.class, args);
	}

}
