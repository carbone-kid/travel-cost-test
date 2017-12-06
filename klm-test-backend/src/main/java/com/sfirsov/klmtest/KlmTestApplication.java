package com.sfirsov.klmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KlmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlmTestApplication.class, args);
	}
}
