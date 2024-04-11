package com.collaborationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CollaborationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborationserviceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return new RestTemplate(factory);
		//return new RestTemplate();
	}

}
