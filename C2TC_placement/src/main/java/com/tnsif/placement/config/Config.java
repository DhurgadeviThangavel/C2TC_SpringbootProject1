	package com.tnsif.placement.config;

	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.CorsRegistry;
	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class Config {

	@Configuration
	@EnableWebMvc
	public class AdminConfig implements WebMvcConfigurer {
		
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/")
				.allowedOrigins("http://localhost:3000/")
				.allowedMethods("GET", "POST", "PUT", "DELETE");
		}

	}

}
