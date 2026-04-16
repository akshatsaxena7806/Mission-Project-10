package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;

/**
 * Main class to start Spring Boot application and configure CORS.
 */
@SpringBootApplication
public class ORSProject10Application {

	//	@Autowired
	//	private FrontCtl frontCtl;

	/**
	 * Application entry point.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ORSProject10Application.class, args);
	}

	/**
	 * Configure CORS settings.
	 */
	@Bean
	public WebMvcConfigurer corsConfig() {
		WebMvcConfigurer w = new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				CorsRegistration cors = registry.addMapping("/**") 
                        .allowedOrigins("http://localhost:4200","http://localhost:8080") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
			}

			//			@Override
			//			public void addInterceptors(InterceptorRegistry registry) {
			//				registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns("/Auth/**");
			//			}
		};
		return w;
	}
}