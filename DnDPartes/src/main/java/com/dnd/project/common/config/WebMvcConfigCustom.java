package com.dnd.project.common.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableSpringDataWebSupport
public class WebMvcConfigCustom extends WebMvcConfigurationSupport {

	//  https://newvid.tistory.com/entry/Spring-boot-Pageable-NuSuchMethodException 
	// pageable init 에러발생 - 핸들러쪽에 argument처리가 안되어있음
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}
