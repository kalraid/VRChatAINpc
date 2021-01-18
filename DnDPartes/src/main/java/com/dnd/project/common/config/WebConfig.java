package com.dnd.project.common.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {

	// cors 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(),
				HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name());
	}

	// swagger 기본 설정
	// https://victorydntmd.tistory.com/341
	// https://editor.swagger.io/
	// https://blog.jiniworld.me/83

	// https://localhost:18080/swagger-ui.html
	// https://localhost:18080/v2/api-docs

	@Bean
	public Docket apiDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				// .apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger.controller"))
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Swagger API Doc").description("More description about the API")
				.version("1.0.0").build();
	}


}
