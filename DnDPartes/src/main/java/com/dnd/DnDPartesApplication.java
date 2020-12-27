package com.dnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DnDPartesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDPartesApplication.class, args);
	} 

	
}
