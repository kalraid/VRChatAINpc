package com.vrchat.ai.npc.config.custom;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AddResourceConfig implements WebMvcConfigurer  {

	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:resources/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:images/");
        registry.addResourceHandler("/web/images/**").addResourceLocations("file:///C:/Users/kalraid/Pictures/");
        registry.addResourceHandler("/web/resources/**").addResourceLocations("file:images/");
    }
}

