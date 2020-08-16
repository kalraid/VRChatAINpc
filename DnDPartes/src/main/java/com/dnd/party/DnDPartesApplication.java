package com.dnd.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dnd.party")
public class DnDPartesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDPartesApplication.class, args);
	} 

	
}
