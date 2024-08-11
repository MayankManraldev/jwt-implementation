package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 

@Configuration
public class RequestInterceptorConfig implements WebMvcConfigurer { 
	
	// Register an interceptor with the registry, Interceptor name : LogInterceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(new LogInterceptor());
	} 
	//* We can register any number of interceptors with our spring application context 
}
