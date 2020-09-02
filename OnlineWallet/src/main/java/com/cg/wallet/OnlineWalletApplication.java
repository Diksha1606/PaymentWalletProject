package com.cg.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OnlineWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineWalletApplication.class, args);
	}
@Bean
public RestTemplate getTemplate()
{
	return new RestTemplate();
	
}
}
