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
@ComponentScan(basePackages = {"com.qintess.ingressos.controller",   //scan dos pacotes com anotações spring
								"com.qintess.ingressos.dao"})		//mostra pro spring onde está os pacotes que contém anotações spring

public class WebMvcConfig extends WebMvcConfigurationSupport { //
	
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/paginas/"); //local onde estará as páginas
		resolver.setSuffix(".jsp"); //páginas serão jsp
		return resolver;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) { // herdado mvc super
		registry.addResourceHandler("/frameworks/**")  // local onde está os arquivos estáticos .css
				.addResourceLocations("/frameworks/");
		
	}
}
