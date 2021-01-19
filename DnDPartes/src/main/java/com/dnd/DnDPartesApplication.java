package com.dnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@ComponentScan
public class DnDPartesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDPartesApplication.class, args);
	} 

	
}
