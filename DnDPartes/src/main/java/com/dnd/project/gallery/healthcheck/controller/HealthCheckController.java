package com.dnd.project.gallery.healthcheck.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api( tags = {"서버 상태 확인 API"}, description = "서버 상태 확인 API")
public class HealthCheckController {

	
	@GetMapping("/healthcheck")
	public HttpEntity<String> isServerAlive() {
		HttpEntity<String> HttpEntity = new HttpEntity<String>("OK : Server is healty");
		return HttpEntity;
	}
	
	
	

}