package com.sarudr.weekendtripservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppMVCConfigure {

	@Bean
	WebMvcConfigurer mvcConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("cheking config");
				registry.addMapping("/**") // Allow CORS for all endpoints
						.allowedOrigins("*")// Configure the allowed origins (you can restrict to specific origins)
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Configure the allowed HTTP methods
						.allowedHeaders("**") ;// Configure the allowed headers
//						.maxAge(3600); // Configure the max age of the CORS pre-flight response in seconds
			}
		};
	}

}
