package com.qintess.ingressos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.qintess.ingressos.controller",   //scan dos pacotes com anota��es spring
								"com.qintess.ingressos.dao"})		//mostra pro spring onde est� os pacotes que cont�m anota��es spring

public class WebMvcConfig extends WebMvcConfigurationSupport { //
	
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/paginas/"); //local onde estar� as p�ginas
		resolver.setSuffix(".jsp"); //p�ginas ser�o jsp
		return resolver;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) { // herdado mvc super
		registry.addResourceHandler("/frameworks/**")  // local onde est� os arquivos est�ticos .css
				.addResourceLocations("/frameworks/");
		
	}
}
