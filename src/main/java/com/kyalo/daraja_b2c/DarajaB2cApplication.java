package com.kyalo.daraja_b2c;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import okhttp3.OkHttpClient;


@SpringBootApplication
public class DarajaB2cApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarajaB2cApplication.class, args);
	}

	@Bean
	public OkHttpClient getOkHttpClient() {
		return new OkHttpClient();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

}
