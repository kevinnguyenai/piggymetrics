package com.piggymetrics.accessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author Kevin
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableCaching
public class AccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessServiceApplication.class, args);
	}

}
